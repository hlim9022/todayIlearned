# 항해99 - Day2 (2022/7/12)

### favoriTube 개발 둘째날
<hr>
우리 프로젝트의 가장 큰 난관인 관심사 선택에 따른 리스트 불러오기. 이 문제를 해결하기 위해 여러방법으로 테스트를 진행해보았다.<br><br>

### 시도 1.
각 관심사를 key-value 형태로 key는 interest'숫자', value는 디폴트값인 0으로 세팅하여 저장하는 방법. 회원가입시 관심사에 체크를 하면 디폴트값을 1로 바꿔 체크가 된 것을 표시하려고 함.
 
``` 
{ 
	'username':username,
	'password':password, 
	'interest':{ 
		'interest1':0, 'interest2':0, ..., 
		'interest10':0}
} 
```
--> 문제점: 새로운 User가 가입을 할 때 모든 관심사에 체크를 하지않더라도 무조건 'interest'는 elements를 10개를 저장해야하므로 DB 저장공간을 쓸데없이 차지하기에 효율적인 방법이 아니다. 또한, 'interest1'과 같이 변수명을 지정하면 명시적이지않을 뿐 아니라 후에 추가해야하는 게시판 이름을 적용할 때 또다시 'interest1':'먹방' 이렇게 정의를 해줘야하기에 비효율적. 탈락!

<br>

### 시도 2.
회원가입시 관심사 체크가 된 value값만 리스트에 저장하는 방법. 변수명 또한 명시적으로 저장

``` 
{ 
	'username':username,
	'password':password, 
	'interest':{ 
		0:'먹방', 1:'스포츠', ...}
} 
```
--> 불필요한 저장공간을 차지하지않고 체크한 값만 interest에 명시적인 변수명으로 저장되어 최적의 방법인 것 같다. 문제는 어떻게 값을 가져와서 DB에 저장해야할지.. 


`interest = request.form.getlist('checkbox')`

위 코드가 해결하는 key였다. html에서 input의 형태 중 하나인 checkbox는 옵션이 여러개일 때 multiple로 선택을 하고 POST를 해줄 경우, `request.form['checkbox']`의 형태로 데이터를 받으면 여러개를 선택하더라도 단 하나의 값만 POST되어진다. `getlist()`는 체크된 모든 값을 리스트로 받아주는 method!<br><br>

### 결론: '시도 2' 방법으로 문제해결!!
