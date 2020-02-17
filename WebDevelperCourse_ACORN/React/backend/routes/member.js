var express = require('express');
var router = express.Router();
var MemberService = require('../service/memberService.js');

// /member/validate?id=newlec2&pwd=123
router.get('/validate', function(req, res, next) {
    let id = req.query.id;
    let pwd = req.query.pwd;

    let service = new MemberService();
    (async ()=>{
        let state = 0;
        let userName ="";
        let authorities = [];
        let defaultRole = "";

        let result = await service.getMember(id);
        // result가 배열로 오기 때문에 
        if(result.length == 0) // 멤버가 없다면 배열 길이가 0일 것이다.
            state = 1;
            
        else{ // 비밀번호가 일치하지 않는다면
            let member = result[0];
            if(member.pwd !== pwd)
                state = 1;
            else{
                state = 0;
                userName = id;

                authorities = await service.getAuthorties(id);
                defaultRole = await service.getDefaultRole(id);               
            }
        }
        
        let model = {
            state,
            principal:{
                userName,
                authorities,
                defaultRole
            }
        };               
    
        res.json(model);
        
    })(); 

    
});


/* GET users listing. */  
// 1:/member/get?id=newlec -> 2:/member/newlec
router.get('/:id', function(req, res, next) {
    //let id = req.query.id;
    let id = req.params.id;

    let service = new MemberService();
    service.getMember(id)
    .then((result)=>{
        res.json(result[0]);
    });

});

module.exports = router;