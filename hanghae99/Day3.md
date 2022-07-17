### favoriTube 개발 셋째날
<hr>

두번째 맞닥들인 Issue.. 글 수정 part__

수정 기능이 아예 안되는 건 아니고 랜덤하게 가끔씩 수정이 되어졌다. 왜 수정이 됐다 안됐다 하는지.. 코드를 하나하나 뜯어봐야겠다.



### 시도 1.

간혹 운좋게 수정이 되는 코드이다. 그래서 처음에는 문제없이 기능이 구현되는 줄 알았는데, 아니었다.

- url, title, comment를 파라미터로 받은 함수 edit()
	- 수정을 위해 id값을 부여한 input태그에 입력된 값을 가져오려고 계획했고, 이 id값은 Unique한 값이여야하기에 생성된 영상의 'title'을 id값으로 부여했다. 'comment'도 동일하게 'comment'값으로 지정했다.


## Script 부분

 
```javascript 
function edit(myurl,mytitle,mycomment) {
            let url = myurl
            let my_title = mytitle
            let my_comment = mycomment
            
            let title = $('#' + my_title).val()
            let comment = $('#' + my_comment).val()
            $.ajax({
                type: 'POST',
                url: '/mylist_post',
                data: {title_give: title, 
			comment_give: comment,
			url_give: url},
                success: function (response) {
                    alert(response['msg'])
                    window.location.reload()
                }
            });
        }
```

## html 부분

```html
<li class="collapse list-unstyled" id="modifySubmenu{{my.title}}">
	<div class="input-group ">
		<span class="input-group-text">title</span>
		<input id="{{my.title}}" type="text" class="form-control">
	</div>
	<div class="input-group">
		<span class="input-group-text">채널설명</span>
		<textarea id="{{my.comment}}" class="form-control" aria-label="With textarea"></textarea>
	</div>

	<button onclick="edit('{{my.url}}','{{my.title}}','{{my.comment}}')">수정 완료</button>
</li>
```
--> 문제점: 만약 'title'값과 'comment'의 내용이 같은 경우, 즉 id값이 같아지면서 Unique해야하는 id값이 2개가 되어버렸다. 이 때문에 수정이 안되었다. 잘못된 코드로 인한 기능 구현 실패.




### 시도 2.
첫번째 시도에서 Unique한 id값을 주지못해 일어난 충돌이었기 때문에, Unique한 값을 부여할 방법을 고민했다. html 부분은 jinja2 반복문이 적용된 부분이었기에 처음 떠오른 생각이 반복문의 인덱스 값이었다. 인덱스는 반복문을 도는 요소 각각이 갖는 Unique한 정보이기 때문이다. 인터넷 검색을 해보니 역시 반복문의 인덱스 값을 구하는 문법이 있었다!!!

 `{{ loop.index }}`

그리고, 숫자인 인덱스값은 혹여라도 숫자가 중복되어 id값이 충돌이 일어날까 걱정되어 더 확실하게 Unique할 수있도록 id값을 지정할 때 인덱스 값 앞에 `category`값도 더해주었다. 이로써 확실히 Unique한 id값을 지정할 수 있었고, 충돌없이 수정기능이 구현되었다!!

## Script 부분


```javascript
function edit(myurl,mycate,idx) {
            let url = myurl
            
            let title = $('#title' + mycate + idx).val()
            let comment = $('#comment' + mycate + idx).val()

            $.ajax({
                type: 'POST',
                url: '/mylist_post',
                data: { comment_give: comment, 
			url_give: url, 
			title_give:title},
                success: function (response) {
                    alert(response['msg'])
                    window.location.reload()
                }
            });
        }
```
## html 부분

```html
<button type="button" data-toggle="collapse" data-target="#collapseExample{{loop.index}}" aria-expanded="false" aria-controls="collapseExample">수정하기</button><button onclick="delete_post('{{my.url}}')">삭제</button>

<div class="collapse" id="collapseExample{{loop.index}}">
	<div class="input-group mb-3">
		<span class="input-group-text">title</span>
		<input id="title{{my.cate}}{{loop.index}}" type="text" class="form-control">
	</div>
	<div class="input-group">
		<span class="input-group-text">채널설명</span>
		<textarea id="comment{{my.cate}}{{loop.index}}" class="form-control" aria-label="With textarea"></textarea>
	</div>
	<button onclick="edit('{{my.url}}','{{my.cate}}','{{loop.index}}')"> 수정 완료</button>
</div>
```