# Shop_Project


## 개발환경
JAVA (JDK 1.8)<br>
Tomcat 8.5<br>
Spring Framework<br>

## 데이터베이스
Oracle SQL과 MyBatis 기술사용

## 프로젝트의 구조
MVC패턴으로 Controller와 Model 부분
![image](https://user-images.githubusercontent.com/83156401/119215567-69db1f80-bb09-11eb-8bb7-7688db0c2ec9.png)
![image](https://user-images.githubusercontent.com/83156401/119215669-17e6c980-bb0a-11eb-8c1d-e4831a6886dc.png)


## 데이터베이스의 구조
-Member테이블(회원정보)<br>
![image](https://user-images.githubusercontent.com/83156401/119215620-c5a5a880-bb09-11eb-9695-59872e440aa3.png)
<br>
-goods테이블(상품정보)<br>
![image](https://user-images.githubusercontent.com/83156401/119215624-cc342000-bb09-11eb-865e-0a713bb7d681.png)
<br>
-Cart테이블(장바구니)<br>
![image](https://user-images.githubusercontent.com/83156401/119215630-d22a0100-bb09-11eb-81de-488311cf60e3.png)
<br>
-Order테이블(주문 및 결제정보)<br>
![image](https://user-images.githubusercontent.com/83156401/119215636-d81fe200-bb09-11eb-9e34-c381e4577505.png)


## 코드정리
![image](https://user-images.githubusercontent.com/83156401/119481702-fbf35a00-bd8d-11eb-8fcb-3fbabc8c7c0f.png)<br>
Common 파일에 main.jsp에 기반이 되는 코드를 넣어줌<br>

![image](https://user-images.githubusercontent.com/83156401/119481784-10cfed80-bd8e-11eb-8cf9-029e4a801655.png)<br>
->Top.jsp 로그인 구현부분<br>

![image](https://user-images.githubusercontent.com/83156401/119481896-30ffac80-bd8e-11eb-8119-c8ef856a762e.png)<br>
->Menu.jsp 의류카테고리 구현부분 <br>

![image](https://user-images.githubusercontent.com/83156401/119482002-5391c580-bd8e-11eb-8b96-988c963e9ddd.png)<br>
->Webcontent.memberForm 코드<br>

메인화면으로 menu와 top에 있는 구현코드를 끌어다가 memberForm 코드에 넣어줌으로써 메인화면 구현완료<br>
![image](https://user-images.githubusercontent.com/83156401/119483078-943e0e80-bd8f-11eb-9985-4e7b30974f29.png)<br>
->Common.top 코드 ,회원가입을 버튼을 눌렀을경우 MemberUIServlet으로 가게 설정
![image](https://user-images.githubusercontent.com/83156401/119483230-b6379100-bd8f-11eb-9376-6f9e1be9fdc1.png)<br>

![image](https://user-images.githubusercontent.com/83156401/119483383-debf8b00-bd8f-11eb-8f15-1595c5040c4a.png)<br>
->Com.controller.member.MemberUIServlet 코드,MemberUIServlet에서는 memberForm으로 회원가입 페이지로만 이동할수있게 sendRedirect를 써줌 ![image](https://user-images.githubusercontent.com/83156401/119483471-f72fa580-bd8f-11eb-9ec7-289f0236a091.png)<br>

![image](https://user-images.githubusercontent.com/83156401/119483567-12021a00-bd90-11eb-917d-a46bf5ac6460.png)<br>
->member.memberFrom 코드 ,memberForm에서는 회원가입 form을 구현해주었음
아이디,비밀번호,전화번호,이메일,주소 등 <br>

![image](https://user-images.githubusercontent.com/83156401/119483653-29410780-bd90-11eb-9fca-cf0f6c53fe79.png)<br>
->Member.memberForm 코드,Memberform에 제이쿼리를 이용하여 form에서 정보를 보낼때(submit)
id와 passwd를 작성하지않았다면 id와 pw를 작성하라는 오류뜨게 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119484106-a53b4f80-bd90-11eb-886a-51b78001336f.png)<br>
비번같은지 체크하는 코드부분<br>
![image](https://user-images.githubusercontent.com/83156401/119484152-b1271180-bd90-11eb-988f-9ac2cd37c3fd.png)<br>
->memberForm 코드,이 memberForm은 MemberAddServlet으로 정보를 보내주게 form을 구현 <br>
![image](https://user-images.githubusercontent.com/83156401/119484218-c2701e00-bd90-11eb-8bbc-6201816072ff.png)<br>
DB에 Shop 테이블을 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119484279-d451c100-bd90-11eb-8591-c4e63be7e0af.png)Sql연동할거니까 mybatis,ojdbc 넣어주기 <br>
![image](https://user-images.githubusercontent.com/83156401/119484390-f0556280-bd90-11eb-83dd-89047da7942f.png) Sql 연동할때 필요한 4가지파일 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119484425-fba88e00-bd90-11eb-8415-5aee9665de9f.png)<br>
->Configuration 코드<br>
![image](https://user-images.githubusercontent.com/83156401/119484487-095e1380-bd91-11eb-86e6-df818a7c1509.png)<br>
->Jdbc.Properties 코드 ,Configuration 과 properties 맞춰주기<br>
![image](https://user-images.githubusercontent.com/83156401/119484717-3f9b9300-bd91-11eb-9399-10e2279ae208.png)<br>
->com.dto.MemberDTO 코드,memberDTO에 기본생성자 Get,set메소드 들을 구현 (sql 레코드들과 이름같게구현)<br>
![image](https://user-images.githubusercontent.com/83156401/119485293-da946d00-bd91-11eb-9267-fb5046c1d34a.png)<br>
->MemberAddServlet 코드, Memberform에서 쓴 회원가입정보를 memberAddServlet으로 보내주고 그 정보들을  MemberAddServlet에 파싱시켜줌 <br>
![image](https://user-images.githubusercontent.com/83156401/119485482-17606400-bd92-11eb-8a35-5764202b1075.png)<br>
MemberAddServlet에서 파싱받은 값을 dto에 객체에 저장시켜주고 
Dto객체를 service로 넘겨줌 , 값을 sql에 insert 시켜줄것이므로 함수이름을
memberAdd로 구현<br> 
![image](https://user-images.githubusercontent.com/83156401/119485524-2a733400-bd92-11eb-9fc3-0d015f43cfe8.png)<br>
Session을 받아 dao객체에 같은 memberadd를 만들어 session과 dto객체를 넣어줌
Insert 명령어를 실행할것이므로 commit()도 필수<br>
![image](https://user-images.githubusercontent.com/83156401/119485674-51316a80-bd92-11eb-8d39-a6739f8642ac.png)<br>
MemberDao에는 insert함수를 이용해 dto와 memberadd(mapper)를 넣어줌<br>
![image](https://user-images.githubusercontent.com/83156401/119485717-5db5c300-bd92-11eb-94c4-06a94c1f3fbb.png)<br>
MemberMapper에는 insert 명령어를 이용하여 받아온 dto값을 insert 시켜주는 sql문 작성<br>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
















































