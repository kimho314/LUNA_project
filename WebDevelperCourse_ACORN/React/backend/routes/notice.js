var express = require('express');
var router = express.Router();
var NoticeService = require("../service/noticeService.js");

/* GET users listing. */
router.get('/list', function(req, res, next) {
  let service = new NoticeService();
  //let notices = service.getList();
  // service.getList((notices)=>{ 
  //   let model = {notices:notices};
  //   res.json(model);
  // });
  
  let page = req.query.p || 1;
  let key = req.query.t || "title";
  let value = req.query.q || "";

  (async ()=>{
    let result = {list:null, count:null};
    let list = await service.getNoticeList({page, query:{key,value}});
    let count = await service.getNoticeCount({key,value});
    
    result.list = list;
    result.count = count;
    res.json(result);
  })();
  

});

router.get('/:id', function(req, res, next) {
  let id = req.params.id;  // req.query.id

  let service = new NoticeService();
  //let notices = service.getList();
  service.get(id, (notice)=>{    
    let model = {notice:notice};
    res.json(model);
  });
});
// 웹 트랜잭션 -> Request->Response
router.post('/open', function(req, res, next) {
  let ar = req.body;

  let service = new NoticeService();
  service.openNoticeList(ar)
  .then(value=>{
    console.log(`result:${value}`);
  });
 
  res.end("ok");
});

module.exports = router;
