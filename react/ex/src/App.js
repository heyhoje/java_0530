import {useState} from 'react'
import Btn from './Btn'
import Input from './Input'
import Main from './Main';
import Login from './Login';
import { Routes, Route, Link } from "react-router-dom";


function App() {
  let [count, setCount] = useState(0);
  let [text, setText] = useState(''); 
  let [display, setDisplay] = useState(''); 

  const clickEvent1 = () => {
    alert('클릭');
    console.log(++count);
  }
  const consoleEvent = (text) => {
    console.log(text);
    console.log(++count);
  }

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
          <Link to="/">홈페이지</Link>
        </li>
        <li>
          <Link to="/login">로그인 페이지</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" exact element={<Main/>} />
        <Route path="/login" element={<Login/>} />
      </Routes>
    </div>
  );
}
  export default App;

// 6. input태그 옆에 버튼을 만들고, 버튼을 클릭하면 화면에 input태그에 있는 값이 출력되도록 작성
// 7. 라우터를 이용하여 로그인페이지로 이동하는 코드 작성(리액트 문서 참고)
// = 기능구현이 아니라 페이지이동만! 