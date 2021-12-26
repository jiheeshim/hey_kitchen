<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>헤이키친 회원가입</title>
	<link rel="stylesheet" type="text/css" href="headerFooter.css">
	<link rel="stylesheet" type="text/css" href="signupStyle.css?ver=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript" src="menuslide.js"></script>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />

		<main>
			<section>회원가입</section>
			<section>
				<div class="sns">
					SNS계정으로 회원가입하기<br>
					<img src="image/navericon.png" />
					<img src="image/kakaoicon.png" />
					<img src="image/googleicon.png" />
				</div>
			</section>
			<section>
				<div class="topDesc">
					<span>직접 회원가입하기</span>
					<span><font color="red">*</font> 필수입력사항</span>
				</div>
				<form name="signupForm" action="signupInsert.jsp" onsubmit="return signupCheck();">
					<table>
						<tr>
							<td class="label_must">
								아이디&nbsp;<font>*</font>
								<font id="idResult_blank" size="2"></font>
							</td>
							<td>
								<input type="text" name="id" size="42" maxlength="20" placeholder="아이디 6 ~ 20 자 입력" onchange="idResultTxt()">
								<button type="button" id="idcheck">중복확인</button>
								<font id="idResult" size="2" color="red"></font>
							</td>
						</tr>
						<tr>
							<td class="label_must">비밀번호 입력&nbsp;<font>*</font></td>
							<td>
								<input type="password" name="pw" size="57" maxlength="20" placeholder="비밀번호 6 ~ 20 자 입력">
							</td>
						</tr>
						<tr>
							<td class="label_must">비밀번호 확인&nbsp;<font>*</font></td>
							<td>
								<input type="password" name="pw2" size="57" maxlength="20" placeholder="비밀번호 6 ~ 20 자 입력">
							</td>
						</tr>
						<tr>
							<td class="label_must">이름&nbsp;<font>*</font></td>
							<td>
								<input type="text" name="name" size="57" maxlength="10">
							</td>
						</tr>
						<tr>
							<td class="label_must">이메일&nbsp;<font>*</font></td>
							<td>
								<input type="text" name="emailfront" size="28" maxlength="50">
								<select class="emailstyle" name="emailback">
									<option value="none">선택하기</option>
									<option value="@gmail.com">@gmail.com</option>
									<option value="@naver.com">@naver.com</option>
									<option value="@hanmail.net">@hanmail.net</option>
									<option value="@nate.com">@nate.com</option>
									<option value="@hotmail.com">@hotmail.com</option>
									<option value="@yahoo.com">@yahoo.com</option>
									<option value="">직접입력</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label_must">휴대번호&nbsp;<font>*</font></td>
							<td>
								<input type="text" name="tel" size="57" maxlength="12" onKeyup="this.value=this.value.replace(/[^0-9]/g, '')">
							</td>
						</tr>
						<tr>
							<td class="labelstyle">성별</td>
							<td>
								<input type="radio" name="gender" value="M">남자&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="gender" value="F">여자&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="gender" checked value="N">선택 안함&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr>
							<td class="labelstyle">생년월일</td>
							<td>
								<input type="text" name="birthyear" size="12" maxlength="4" placeholder="연도(4자리)" onKeyup="this.value=this.value.replace(/[^0-9]/g, '')">
								<%-- 키보드를 눌렀다 땠을 떄, 0부터 9까지의 문자 외의 문자는 빈칸으로 대체 --%>
								<select class="selectstyle" name="birthmonth">
									<option value="0">월</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								<select class="selectstyle" name="birthdate">
									<option value="0">일</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="labelstyle">우편번호</td>
							<td>
								<input type="text" name="postcode" size="12" maxlength="6" readonly>
								<button type="button" id="search" onclick="searchPostcode()">찾기</button>
							</td>
						</tr>
						<tr>
							<td class="labelstyle">주소</td>
							<td>
								<input type="text" name="addr1" size="27" maxlength="50" readonly>
								<input type="text" name="extraAddr" size="18" readonly>
							</td>
						</tr>
						<tr>
							<td class="labelstyle">상세주소</td>
							<td>
								<input type="text" name="addr2" size="60" maxlength="50">
							</td>
						</tr>
						<tr>
							<td class="labelstyle">우리집 가구원 수</td>
							<td>
								<select class="selectstyle" name="familynum">
									<option value="0">선택</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6+</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="labelstyle">
								추천인 코드
								<font id="refResult_blank" size="2" color="red"></font>
							</td>
							<td>
								<input type="text" name="joincode" size="45" maxlength="20" onchange="refResultTxt(this.form.joincode)">
								<button type="button" id="refcheck">코드확인</button>
								<font id="refResult" size="2" color="red"></font>
							</td>
						</tr>
					</table>
					<br>

					<hr>

					<div class="terms_title">이용 약관 동의</div>
					<p><input type="checkbox" onchange="checkAll()"> 모든 약관에 동의합니다.</p>

					<p><input type="checkbox" onchange="checkTerms()"> (필수) 서비스 약관에 동의합니다.
					<textarea disabled="disabled">
개인정보보호법에 따라 헤이키친에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.

1. 수집하는 개인정보
2. 수집한 개인정보의 이용
3. 개인정보의 보관기간
					</textarea></p>

					<p><input type="checkbox" onchange="checkTerms()"> (필수) 개인정보 약관에 동의합니다.
					<textarea disabled="disabled">
개인정보보호법에 따라 헤이키친에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.

1. 수집하는 개인정보
2. 수집한 개인정보의 이용
3. 개인정보의 보관기간
					</textarea></p>

					<p><input type="checkbox" name="marketing" onchange="checkTerms()"> (선택) 마케팅 약관에 동의합니다.
					<textarea disabled="disabled">
개인정보보호법에 따라 헤이키친에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.

1. 수집하는 개인정보
2. 수집한 개인정보의 이용
3. 개인정보의 보관기간
					</textarea></p><br>
				
					<div class="bottom_btn">
						<button type="submit" id="signupBtn">가입</button>
					</div>
				</form>
			</section>
		</main>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script type="text/javascript" src="postcode.js"></script>
		<script type="text/javascript" src="signupScript.js"></script>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>