var mysql = require("mysql");

module.exports = class MemberService{
    getMember(id){
        return new Promise((resolve, reject)=>{
            let con = mysql.createConnection({
                host:"dev.notepubs.com",
                database:"lecture",
                user:"lec",
                password:"111"
            });

            con.connect();
            con.query("SELECT * FROM Member WHERE id=?", [id], (err, results, fields)=>{
                if(err) {
                    reject(err.message);
                    throw err;
                }
                resolve(results);
            });
            con.end();
        });
    }

    getAuthorties(id){ // ["ROLE_STUDENT", "ROLE_ADMIN"]
        return new Promise((resolve, reject)=>{
            let con = mysql.createConnection({
                host:"dev.notepubs.com",
                database:"lecture",
                user:"lec",
                password:"111"
            });

            con.connect();
            con.query("SELECT * FROM MemberRole WHERE memberId=?", [id], (err, results, fields)=>{
                if(err) {
                    reject(err.message);
                    throw err;
                }
                resolve(results.map(mr=>mr.roleId));
            });
            con.end();
        });
    }

    getDefaultRole(id){ // "ROLE_STUDENT" 문자열 반환
        return new Promise((resolve, reject)=>{
            let con = mysql.createConnection({
                host:"dev.notepubs.com",
                database:"lecture",
                user:"lec",
                password:"111"
            });

            con.connect();
            con.query("SELECT * FROM MemberRole WHERE memberId=? AND `default`=1", [id], (err, results, fields)=>{
                if(err) {
                    reject(err.message);
                    throw err;
                }
                console.log(results);
                resolve(results[0].roleId);
            });
            con.end();
        });
    }

}