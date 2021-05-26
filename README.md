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
![image](https://user-images.githubusercontent.com/83156401/119644937-725c8e80-be58-11eb-873a-ef66060d9cd7.png)<br>
->MemberAddServlet 코드,
그럼 이제 Memberform에서  값을 넣어 회원가입을 실행한다면 sql에 회원정보값이 insert될것임<br>
Insert된후에 session에 회원가입성공이라는 단어를 저장시켜주고 바로 Main으로 이동할수있게 sendRedirect를 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119645111-a2a42d00-be58-11eb-874a-bd145e7c7cc6.png)<br>
->main코드,그럼 바로 회원가입성공후 Main으로 넘어갈것이고 Main에 setattribute 해준 memberAdd 키값을 받아와 mesg에 저장시켜주고
그 메시지를 alert에 넣어 회원가입성공이라는 창을 띄어줌<br>

![image](https://user-images.githubusercontent.com/83156401/119645209-c10a2880-be58-11eb-87a0-cd33dccfd20a.png) Memberform에 정보를 입력하고 회원가입 클릭<br>
![image](https://user-images.githubusercontent.com/83156401/119645280-d5e6bc00-be58-11eb-8398-f7544509b3da.png) 회원가입성공 alert 출력<br>
![image](https://user-images.githubusercontent.com/83156401/119645312-de3ef700-be58-11eb-8080-73701ed6df9e.png) 그 후 바로 main으로 이동<br>
<br>
※Userid가 db에 이미 있는 값인지 아닌지 알아보는 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119645365-eb5be600-be58-11eb-9021-6816ee49a5db.png)<br>
 Userid에 값을 쓸때 실행되는 Ajax 코드구현,MemberIDCheckServlet으로 값을 파싱해줄것임<br>
![image](https://user-images.githubusercontent.com/83156401/119645499-0b8ba500-be59-11eb-9557-474ee2be05bb.png)<br>
->MemberIdCheckServlet 코드,userid를 MemberForm에서 받아와서 파싱해주고 Service 객체를 얻어와 idcheck 함수로 넘겨줌<br>
( 아이디가 db에 존재한지 존재하지않는지 알아볼것이기에 count라고 변수이름 붙여줌)<br>
![image](https://user-images.githubusercontent.com/83156401/119645618-30801800-be59-11eb-95fa-d722e9d98b36.png)<br>
->MemberService 코드,세션받아와 dao 객체를 만들어 Session과 userid를 넘겨줌<br>
![image](https://user-images.githubusercontent.com/83156401/119645688-4261bb00-be59-11eb-9fbe-ca98dc96adf1.png)<br>
->MemberDAO 코드, Userid를 받아와 idCheck라는 Id로 mapper를 만들어줄것임<br>
![image](https://user-images.githubusercontent.com/83156401/119645781-602f2000-be59-11eb-90ed-c258159d7020.png)<br>
->Mapper에 count로 userid 값을 이미 가지고있는지 없는지 db코드 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119645830-6c1ae200-be59-11eb-8775-76568ae21d36.png)<br>
->MemberIdCheckServlet 코드,Int Count로 디비의 select count문을 받아주고 count가 1일경우 아이디가 있기때문에 mesg에 아이디중복을 담아주고 아닐경우 mesg에 아이디사용가능 담아줌<br>
![image](https://user-images.githubusercontent.com/83156401/119645910-805edf00-be59-11eb-902b-30bc22843915.png)<br>
->memberForm 코드,Userid에 값을 입력할때 IdCheckServlet에 mesg를 받아와 아이디 옆 span 태그에 있는 result에 mesg값을 넣어줌 (responseData로 받아옴)<br>
![image](https://user-images.githubusercontent.com/83156401/119645989-97053600-be59-11eb-9ae2-63763f34b833.png)<br>
Top에서 로그인을 클릭하면 LoginUIServlet으로 가게 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119646034-a6847f00-be59-11eb-99a2-0928926ca3c1.png)<br>
-> member/loginform 코드,LoginUIServlet은 loginform으로 가주게 Sendredirect <br>
제이쿼리로 아디비번 입력안하면 Alert 뜨게 구현, form은 submit할경우 LoginServlet으로 이동함<br>
![image](https://user-images.githubusercontent.com/83156401/119646136-c7e56b00-be59-11eb-82eb-ebd46b8e4378.png)<br>
->Com.controller.member.loginServlet코드,Userid,passwd 파싱받아서 map에 저장<br>
![image](https://user-images.githubusercontent.com/83156401/119646213-dcc1fe80-be59-11eb-9733-471ee64f805f.png)<br>
->MemberService 코드,Session과 map 넘겨줌<br>
![image](https://user-images.githubusercontent.com/83156401/119646259-ed727480-be59-11eb-8537-b64aba8e4bf3.png)<br>
->MemberDTO 코드<br>
![image](https://user-images.githubusercontent.com/83156401/119646288-f6634600-be59-11eb-8de9-9808ba5ee8e8.png) <-mapper<br>
![image](https://user-images.githubusercontent.com/83156401/119646358-0713bc00-be5a-11eb-9dc5-d41fea355776.png)<br>
->LoginServlet 코드, Select해서 그 값에 해당하는 회원이 있다면 main으로 이동 없다면 loginUIServlet으로 다시 로그인창을 띄어주게 구현<br>
Session에 dto값을 login값으로 저장<br>
![image](https://user-images.githubusercontent.com/83156401/119646411-198df580-be5a-11eb-9609-ed175b9a1306.png)<br>
->top코드, Session 값을 받아 Dto안에 값이 있다면 top에 로그아웃을 띄어주고 없다면 로그아웃 대신 로그인을 띄어주는 Top코드 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119646497-3296a680-be5a-11eb-9e54-0dd388b4752f.png)<br>
->top코드,로그아웃에 LogoutServlet 연결<br>
![image](https://user-images.githubusercontent.com/83156401/119646540-3fb39580-be5a-11eb-9661-08b436e8b74b.png)<br>
->LogoutServlet코드, 세션 지워주고 main으로 바로 이동<br>
<br>
※상품테이블에있는 데이터들을 MemberAddServlet으로가져오는 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119646951-b05ab200-be5a-11eb-9a34-f5490c79407f.png)<br>
->GoodsListServlet코드,Main에 카테고리가 top(상의)인 상품들을 띄어줄것이기때문에 카테고리를 top인 상품들을 select 해줄코드를 구현<br>
![image](https://user-images.githubusercontent.com/83156401/119647035-c49eaf00-be5a-11eb-9510-3d16ce93ad76.png)<br>
->goodsService코드<br>
![image](https://user-images.githubusercontent.com/83156401/119647157-e8fa8b80-be5a-11eb-9cb8-1569fbb5a616.png)<br>
![image](https://user-images.githubusercontent.com/83156401/119647167-edbf3f80-be5a-11eb-8a1c-143ca5627d0b.png)<br>
->GoodsDAO 코드 , Goodsmapper에 goodsList라는 id를 가진 select문을 작성 <br>
![image](https://user-images.githubusercontent.com/83156401/119647217-f9ab0180-be5a-11eb-9057-6d8f8fff7455.png)<br>
->GoodsListServlet코드 , mapper로 받아온 상품 list 데이터를 goodsList에 저장하고 Main으로 이동시켜주는 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119647278-09c2e100-be5b-11eb-9cb7-8dd70a22f257.png)<br>
->Main 코드, goods/goodsList도 추가,상품들을 보여줄 코드임<br>
![image](https://user-images.githubusercontent.com/83156401/119647332-1a735700-be5b-11eb-9994-0a5d17bf57e9.png)<br>
![image](https://user-images.githubusercontent.com/83156401/119647412-324adb00-be5b-11eb-8dc3-26326309f419.png)<br>
->Goods/goodList코드, GoodsListServlet에서 지정해준 goodsList 값을 request로 가져와 list로 받아줌 이 list를 for문을 돌며 하나씩 하나씩 값을 받아와 table에 넣어줌<br>
![image](https://user-images.githubusercontent.com/83156401/119647434-3971e900-be5b-11eb-9ef9-51fc3913a97a.png)<br>
Db에서 값을 받아온후에 이제 코드를 실행해야 상품들의 정보와 함께 구현했던 코드들이 모두 실행되기때문에 main이 아닌 GoodsListServlet에서 코드를 실행해야 코드들이 오류없이 모두 구현됨<br>
그래서 아예 com.controller.main/MainServlet을 만들어서 GoodsListServlet과 같은 코드를 만들어주었음 이제 코드의 시작,메인은 여기에서 시작<br>
![image](https://user-images.githubusercontent.com/83156401/119647529-56a6b780-be5b-11eb-91a0-d925b7cd1727.png)<br>
->Common/menu 코드 , top,dress,outer,buttom 클릭했을때 나눠주는 코드<br>
![image](https://user-images.githubusercontent.com/83156401/119647566-60c8b600-be5b-11eb-8e8a-0b1ae440427d.png)
![image](https://user-images.githubusercontent.com/83156401/119647569-632b1000-be5b-11eb-830e-4f3367c5f4ed.png)<br>
mainServlet에서 goodslist를 가져와 코드를 실행되야하기때문에 main으로 sendRedirect 되어있던 코드를  모두 mainServlet 으로 주소변경시켜줌 (로그인,로그아웃,회원가입 코드)<br>
<br>
※ 회원정보수정 , mypage 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119647708-8eadfa80-be5b-11eb-936f-3c3d0a3b2826.png)<br>
->Com.controller.member/loginServlet 코드,회원인경우 dto정보를 받아 login값으로 저장해주었던 loginServlet 코드<br>
![image](https://user-images.githubusercontent.com/83156401/119647744-9cfc1680-be5b-11eb-8c7d-739c07c56084.png)<br>
->mypageServlet 코드, 그 login값을 받아와 dto로 받아주고 dto가 있다면 (회원정보,로그인정보가 있음)<br>
다시 그 dto의 userid 값을 받아와 dto에 x로 저장 , 그 후 session에 다시 login으로 이 x값을 저장 ,그후 mypage로 이동<br>
Else(회원정보가없음) 인 경우 loginForm으로 되돌아가게 UIServlet으로 링크주고 Mesg에 로그인필요하다고 담아줌<br>
![image](https://user-images.githubusercontent.com/83156401/119647843-b7ce8b00-be5b-11eb-85f0-7797fd962393.png)<br>
->webcontent/mypage코드<br>
![image](https://user-images.githubusercontent.com/83156401/119647884-c4eb7a00-be5b-11eb-97a2-ad3052324018.png)<br>
->member/mypage코드,MypageServlet에서 설정했던 Login값을 받아와 dto로 받아주고 값을 하나씩 뽑아와서 form에 넣어주기<br>
그럼 로그인한 회원의 정보가 뜨고 거기에서 변경할수있는 부분은 변경가능하게 form작성<br>
<br>
※ 아이디찾기코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119648022-eea4a100-be5b-11eb-9be3-95bffabe8643.png)
->idSearch 코드<br>
![image](https://user-images.githubusercontent.com/83156401/119648060-f82e0900-be5b-11eb-8eb0-65d3937e6d61.png)<br>
->Member/idSearch 코드, idSearch가 member/idSearch코드를 Include 하고있음 여기에 찾기값을 파싱해주는 Servlet은 memberIdSearchServlet<br>
![image](https://user-images.githubusercontent.com/83156401/119648451-7094ca00-be5c-11eb-95d1-048721be2715.png)<br>
->Com.controller.member.MemberIdSearchServlet 코드, Member/idsearch 코드의 값을 파싱 받아와 dto에 넣고 Dto 정보(이메일,전화번호)와 같은정보를 가진 회원의 userid를 가져옴<br>
![image](https://user-images.githubusercontent.com/83156401/119648534-899d7b00-be5c-11eb-9a8e-d616de39c151.png)<br>
Userid가 null이면 회원정보가 있지않은것이므로 MemberIdSearchUIServlet(dispatcher로 idsearch로가게 해준코드) 으로 가게 설정하고 Alert를 설정해줄 mesg에 메시지를 넣어줌<br>
![image](https://user-images.githubusercontent.com/83156401/119648571-9326e300-be5c-11eb-8db9-fa80d757a331.png)
->Common/idsearch 코드, Mesg 값을 받아 mesg가 null이 아닐경우 (회원이아닐경우) Alert로 설정해준 mesg값 띄어주기<br>
![image](https://user-images.githubusercontent.com/83156401/119648641-ab96fd80-be5c-11eb-9dc0-8a92ba3f92e3.png)<br>
일치하는 정보가 있을경우엔 email과 useride를 request  set 해주고 sendMailServlet으로<br>
![image](https://user-images.githubusercontent.com/83156401/119648685-ba7db000-be5c-11eb-866d-419468e4befa.png)<br>
->com.mail.sendMailServlet코드, Mail값과 userid값 받아와서 메일 보내는 코드구현해주기 sendMail코드도 ~<br>
<br>
※ 상품을 클릭했을때 상품상세보기를 볼수있는 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119648802-d719e800-be5c-11eb-86e0-dd02ee83d137.png)<br>
->goods.Goodslist코드,goddsListServlet에서 request해준 Gcode를 받아와 주소로넘겨주고있음<br>
![image](https://user-images.githubusercontent.com/83156401/119648850-e26d1380-be5c-11eb-8fb7-8451c3efaf5f.png)<br>
->Com.controller.goods.GoodsRetrieveServlet코드, Gcode를 받아와 gcode와 일치하는 상품데이터들을 dto로 뽑아옴<br>
뽑아온 dto데이터를 goodsRetrieve로 setattribute로 저장 그리고 Goods.goodsRetrieve로 바로 Sendredirect하게 코드구현 <br>
![image](https://user-images.githubusercontent.com/83156401/119648931-fb75c480-be5c-11eb-8355-e64c5e05aadf.png)<br>
![image](https://user-images.githubusercontent.com/83156401/119648977-0c263a80-be5d-11eb-8ef9-a4d52156d37b.png)<br>
->Goods/goodsRetrieve코드,GoodsRetrieveServlet 코드에서 지정해준 goodsRetrieve를 request해서 Dto를 가져오고 값을 하나씩 뽑아서 form에 넣어줌 <br>
<br>
※카트저장하기 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649032-1f390a80-be5d-11eb-94d6-bb96b9928eea.png)
->Goods/GoodsRetrieve코드,상품사이즈, 코드,이미지,가격 등을 받아와 GoodsCartServlet에 파싱해줌 Form에없는값은 Hidden으로 숨겨주고 저기에서 받아올것임<br>
![image](https://user-images.githubusercontent.com/83156401/119649070-2e1fbd00-be5d-11eb-981f-a91391b3cbf1.png)<br>
->Com.controller.goods.GoodsCartServlet코드,goodsRetrieve코드에서 값들을 파싱받아오고 login값받아와 session으로 받아와<br>
로그인되어있는지 아닌지 확인해서 로그인되어있는 사람만(회원전용) 장바구니에 담을수있게 코드구현<br>
값들을 받아 CartDTO에 객체를 만들어 값들을 저장시켜주고 이 dto를 받아 db에 Insert 시켜줌<br>
![image](https://user-images.githubusercontent.com/83156401/119649162-48f23180-be5d-11eb-98fa-02e0df9d58c9.png)<br>
Insert가 완료되면 redirect로 다시 Goods/GoodsRetrieve로 갈수있게 RetrieveServlet(jsp로 dispatcher해주는 코드)으로 넘겨주는 코드구현<br>
주소뒤에 gCode를 넣어줘서 내가 선택하고있는 상품코드의 브라우저로 다시갈수있게해주는 코드로 구현<br>
안되면 로그인이 필요하다는 문구와함께 loginForm으로 갈수있게 LoginUIServlet으로 갈수있는 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649243-60311f00-be5d-11eb-8c9f-e52c2f77e087.png)<br>
->Goods/goodsRetrieve코드,GoodsCartServlet에서 설정해준 mesg를 받아와서 상황에 맞게 mesg alert가 뜰수있게 코드구현<br>
<br>
※카트목록보는 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649315-7343ef00-be5d-11eb-911c-fe7d62d0a770.png)
->Com.controller.goods.CartListServlet 코드,Dto값 받아와 로그인상태인지 아닌지 확인후 로그인상태라면 userid값을 받아와<br>
해당하는 동일한 Userid값을 가지고있는 유저가 cart에 담은 상품들을 select해서 List에 담아줌 그후 request에 cartList로 list를 담아서 저장<br>
그후에 list들을 들고 cartList.jsp로 dispatcher하도록 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649403-8eaefa00-be5d-11eb-9f1b-f9aaf26ebde1.png)<br>
->webcontent/cartList 코드, Goods/cartList를 include 시켜줌<br>
![image](https://user-images.githubusercontent.com/83156401/119649463-9ff80680-be5d-11eb-9b1c-6aab2f510811.png)<br>
->Goods/cartList코드,Com.controller.goods.CartListServlet에서 설정해준 request값을 뽑아서 form에 값들을 넣어줌<br>
<br>
※ 카트 개별삭제 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649545-b736f400-be5d-11eb-9553-0da9fe45b82e.png)<br>
->Goods/cartList코드,삭제버튼을 클릭하면 num을 받고 CartDelServlet으로 가게 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649606-c7e76a00-be5d-11eb-9beb-4168ea137210.png)<br>
cartList코드의 삭제버튼코드부분 ,삭제버튼을 누르면 주문번호인 
num값을 받아올수있게 코드구현<br>
![image](https://user-images.githubusercontent.com/83156401/119649642-d33a9580-be5d-11eb-8f8e-e72d168ba41a.png)<br>
->Com.controller.goods.CartDelServlet코드,로그인이 되어있을경우 Num을 받아오고 받아온 num을 이용해 num이 가지고있는 Cart정보를 delete해줌<br>
그후에 CartListServlet으로 다시 이동시켜줌 CartListServlet으로 dispatcher해주는 이유는 CartListServlet코드안에는<br>
Userid를 받아와서 그 userid가 담은 cart정보를 보여주기때문에 해당 주문번호의 cart정보를 삭제시키고 <br>
남은 userid가 가진 cart정보를 select해주는  CartListServlet  코드로 Dispatcher해주는것임<br>
<br>
※카트갯수 수정 코드구현<br>

































































































