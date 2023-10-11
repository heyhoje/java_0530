import {useState} from 'react'
import Btn from './Btn'
import Input from './Input'


function App() {
  let [count, setCount] = useState(0);
  let [text, setText] = useState(''); // 문자열을 저장하는 text라는 state만들기
  let [display, setDisplay] = useState(''); // 화면에 출력하는 display state

  const clickEvent1 = () => {
    alert('클릭');
    console.log(++count);
  }
  const consoleEvent = (text) => {
    console.log(text);
    console.log(++count);
  }

  // 함수명에 들어가야할 것이 inputEvent일까요? inputChange일까요~? (체인지요~~)
  const inputChange = (e) => {
    setText(e.target.value);
  }
  console.log('input태그 입력창 : ', text);

  return (
    <div className="App">
      <Input type="text" inputEvent={inputChange} placeholder="내용을 입력하세요"/>
      <Btn text="출력" event={() => setDisplay(text)}></Btn>
      <h1>{display}</h1>
      <ul>
        <li>
          <a href="#">홈페이지</a>
        </li>
        <li>
          <a href="#">로그인 페이지</a>
        </li>
      </ul>
      <main>메인입니다.</main>
      <br/>
      <br/>
      <Btn text="버튼1" event={clickEvent1}/>
      <Btn text="버튼2" event={() => {console.log('클릭'); count++; console.log(count)}}/>
      <Btn text="버튼3" event={() => consoleEvent(1)}/>
    </div>
  );
}
  export default App;

// 5. input태그에 입력을 하면, 입력된 문자열을 콘솔에 출력하는 코드를 작성
// => 키를 누를 때마다 콘솔에 출력 ex) (입력) 12345 -> (출력) 1, 12, 123, 1234, 12345
// ㄴ 부모요소 이벤트 어쩌구 뭐라는거냐구

// 6. input태그 옆에 버튼을 만들고, 버튼을 클릭하면 화면에 input태그에 있는 값이 출력되도록 작성
// 7. 라우터를 이용하여 로그인페이지로 이동하는 코드 작성(리액트 문서 참고)