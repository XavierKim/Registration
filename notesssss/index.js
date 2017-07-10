
/*
 * GET home page.
 */

var FCM 	= require('fcm').FCM;
var apiKey 	= 'AAAA-1eWsFk:APA91bFrAH6fS2ZpkK76WRR-IXHHIZDF4UTd4Lp9_U5y7pSr_Svn0GE4_sihLvKJ2aq5sbebqPJEiQbGFJ8cGaex97-q1l1PiNzQaDgh1wmpaoXWnS15ZlhiPYV2zaqm87iaqrwaVUE_';
var fcm 	= new FCM(apiKey);

	
exports.index 		= function(req, res){
  res.render('index', { title: '푸시서버' });
};
exports.sendPush 	= function(req, res){
	console.log( req.body.token, req.body.msg );
	// 메시지 구성
	var message = 
	{
		// 유저의 등록된 ID -> 푸시를 받고자 하는 유저 ID -> 유저의 token
	    registration_id: req.body.token, // required
	    collapse_key: ''+ Math.floor(Math.random()*1000), 
	    // 데이터는 문자열로 
	    data: JSON.stringify({body:req.body.msg, title:req.body.title})
	};
	// 전송
	fcm.send(message, function(err, messageId){
		// 렌더링이 아니라서 한글 처리
		res.writeHead(200, {'Content-Type': 'text/html;charset=utf-8'});
	    if (err) {
	        //console.log("Something has gone wrong!");
	    	res.end("<script>alert('전송실패:"+err+"');history.back();</script>");
	    } else {
	        //console.log("Sent with message ID: ", messageId);
	    	res.end("<script>alert('전송성공:"+messageId+"');history.back();</script>");
	    }
	});	
	//res.render('index', { title: '푸시서버' });
};















