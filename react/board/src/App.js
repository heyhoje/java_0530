import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from "./Home";
import Header from "./Header";
import Insert from "./Insert";
import { useState } from 'react'


function App() {
  // 샘플데이터, 객체는 객체로 보내줘야함
  let [list, setList] = useState([{
    num : 1,
    title : '공지사항',
    writer : 'admin'
  }, {
    num : 2,
    title : '첫번째 게시글',
    writer : '나야'
  }
  ]);

  const deleteBoard = (num) => {
    let tmpList = list.filter(item => item.num != num); // filter : 이 조건을 만족하는 요소들만 리스트로 빼내오자. 
    // 같으면 빼내야 하기 때문에 '다르면' 하나의 배열을 다시 만듬
    setList(tmpList); // 그리고 만들어진 배열을 tmpList로 수정해줌
  }

  const addBoard = (board) => {
    setList([board, ...list]); // 그냥 이렇게 합시다 하고 바꿈. 간단하게, ([보드, 기존의 배열])
    // setList(prev => [board, ...prev]); // setter의 다른 방식 중 하나...
  }

  // 요소에 <Home/>, <Insert/> 컴포넌트를 넣어야 하는데, 
  // 변수인데 아무것도 없는 변수를 넣어서 에러가 떴었다. 

  // props : 부모가 자식에게 데이터를 전송하는 것
  return (
    <BrowserRouter>
      <Header/>
      <Routes>
        <Route path="/" exact element={<Home list={list} deleteBoard={deleteBoard} add={addBoard}/>} />
        <Route path='/insert' element={<Insert/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;