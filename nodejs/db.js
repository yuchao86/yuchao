var mysql = require('mysql');

var TEST_DATABASE = '***';
var TEST_TABLE = 'loginuser';

//创建连接
var client = mysql.createConnection({
  host: '101.201.152.200',
  user: 'root',
  password: '***',
});

client.connect();
client.query("use " + TEST_DATABASE);

client.query(
  'SELECT * FROM '+TEST_TABLE,
  function selectCb(err, results, fields) {
    if (err) {
      throw err;
    }

      if(results)
      {
          //for(var i = 0; i < results.length; i++)
          for(var i = 0; i < 10; i++)
          {
              console.log("%d\t%s\t%s", results[i].ID, results[i].LOGIN_NAME, results[i].TEL);
          }
      }
    client.end();
  }
);
