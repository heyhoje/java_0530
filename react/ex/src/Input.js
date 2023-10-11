import { useState } from 'react'

function Input({inputEvent}){
	return(
		<input type="text" onChange={inputEvent}/>
	)
}

export default Input;

// 4. 컴포넌트 생성 및 배치 (컴포넌트명:Input/태그:input/파일명:Input.js)
// 5. input태그에 입력을 하면, 입력된 문자열을 콘솔에 출력하는 코드를 작성
// => 키를 누를 때마다 콘솔에 출력 ex) (입력) 12345 -> (출력) 1, 12, 123, 1234, 12345
// ㄴ 부모요소 이벤트 어쩌구 뭐라는거냐구