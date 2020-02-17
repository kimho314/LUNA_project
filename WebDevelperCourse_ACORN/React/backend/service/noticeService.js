var mysql = require("mysql");

module.exports = class NoticeService{
    constructor(){
        
        // this.con = mysql.createConnection({
        //     host:"dev.notepubs.com",
        //     database:"lecture",
        //     user:"lec",
        //     password:"111"
        // });
    }

    openNoticeList(notices){
        return new Promise((resolve, reject)=>{
            // 1. 항목당 업데이트 : 4-> 4번 반복

            // 2. 쿼리를 묶어서... open 목록과 close 목록을 따로 해서 2번 반복
            //  : update Notice set open=true where id in (100,103);
            let openIds = notices.filter(n=>n.open).map(n=>n.id); //[100,103];
            let closeIds = notices.filter(n=>!n.open).map(n=>n.id);

            if(openIds.length == 0)
                openIds = [0];

            if(closeIds.length == 0)
                closeIds = [0];

            let openSql = `update Notice set open=true where id in (${openIds})`;
            let closeSql = `update Notice set open=false where id in (${openIds})`;
            
            // 트랜잭션 => 업무단위
            // 트랜잭션 처리 => 업무단위가 하나로 깨지지 않고 실행되도록 하는 작업 commit 아니면 rollback

            let con = mysql.createConnection({
                host:"dev.notepubs.com",
                database:"lecture",
                user:"lec",
                password:"111"
            });
            
            con.connect();

            con.beginTransaction(function (err) {
                if (err) { throw err; }
                con.query(openSql, function (error, results, fields) {
                    if (error) {
                        return con.rollback(function () {
                            reject('failed');
                            throw error;
                        });
                    }

                    var log = 'Post ' + results.insertId + ' added';

                    con.query(closeSql, function (error, results, fields) {
                        if (error) {
                            return con.rollback(function () {
                                reject('failed');
                                throw error;
                            });
                        }
                        con.commit(function (err) {
                            if (err) {
                                return con.rollback(function () {
                                    reject('failed');
                                    throw err;
                                });
                            }

                            resolve('success!');
                            console.log('success!');
                        });
                    });
                });
            });

        });
    }

    getNoticeList({page=1, query:{key,value}={key:"title",value:""}}){
        return new Promise((resolve, reject)=>{
            let offset = (page-1)*10;
            let sql = `SELECT * FROM Notice  
                        where ${key} like '%${value}%'
                        order by regdate desc
                        limit ${offset}, 10`;

            this.con = mysql.createConnection({
                host:"dev.notepubs.com",
                database:"lecture",
                user:"lec",
                password:"111"
            });
            
            this.con.connect();
            this.con.query(sql, (err, results, fields)=>{
                if(err) {
                    throw new Error(err.message);
                    reject(err.message);
                }
                resolve(results);
            });
            this.con.end();
        });
    }

    getNoticeCount({key="title", value=""}){
        return new Promise((resolve, reject)=>{            
            let sql = `SELECT count(id) count FROM Notice
                        where ${key} like '%${value}%'`;
            
            this.con = mysql.createConnection({
                host:"dev.notepubs.com",
                database:"lecture",
                user:"lec",
                password:"111"
            });

            this.con.connect();
            this.con.query(sql, (err, results, fields)=>{
                if(err) {
                    throw new Error(err.message);
                    reject(err.message);
                }
                resolve(results[0].count);
            });
            this.con.end();
        });
    }

    getNotice(id){
        return new Promise((resolve, reject)=>{
            this.con.connect();
            this.con.query("SELECT * FROM Notice WHERE id=?", [id], (err, results, fields)=>{
                if(err) {
                    throw err;
                    reject(err.message);
                }
                resolve(results);
            });
            this.con.end();
        });
    }

}