<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	/* 
		class Test{
			int number = 10;
			
			String name = "안녕하세요";
			
			int sum(int a, int b){
				return a + b;
			}
		}
	
		Test myTest = new Test();
		myTest.number;
	}
	*/
	var jsonObject = {
			"number":10, "name":"안녕하세요", 
			"sum":function(a, b){return a+b;}
	}
	console.log(jsonObject.number);
	console.log(jsonObject["name"]);
	console.log(jsonObject.sum(10,30));
	
	var jsonArr = [
		{"name":"정도전", "IQ":200},
		{name:"이방원", IQ:150}
	];
	console.log("이방원의 아이큐 : "+jsonArr[1].IQ)
	
	var jsonObject2 = {
		"fruit_arr":["apple","banana","orange"],
		"city_obj":{"name":"sungnam", "region":"Gyeonggi-do",
			myObj:{"num":100}
		}
	}
	
	console.log("세번째 과일 : "+jsonObject2.fruit_arr[2]);
	console.log("성남시가 속한 지역:"+jsonObject2.city_obj.region);
	console.log(jsonObject2.city_obj.myObj.num);
	
</script>
</head>
<body>

</body>
</html>