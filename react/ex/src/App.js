import {useState} from 'react'
import Btn from './Btn'

function App() {
  // 1. 버튼1 : alert('클릭') / 버튼2 : 콘솔창에 '클릭' / 버튼3 : 콘솔창에 1 <- 매개변수가 있는 어쩌구***다시들어야함 
  // ~이벤트를 추가하는 3가지 방법~ const를 쓴다. 애로우함수를 쓴다. 어쩌구저쩌구 한다. 
  // const clickEvent1 = () => {alert('클릭');}
  // const consoleEvent = (text) => console.log(text);
  
  // 3. 버튼이 클릭될때마다 클릭된 횟수를 증가하고, 콘솔에 출력하는 코드 ( 놓침 ㅅㅂ )
  let [count, setCount] = useState(0);
  // let data = useState(0);
  // let count = data[0];
  // let setCount = data[1];

  const clickEvent1 = () => {
    alert('클릭');
    console.log(++count);
    // count++;
    // console.log(count);
  }
  const consoleEvent = (text) => {
    console.log(text);
    console.log(++count);
  }

  return (
    <div className="App">
      <Btn text="버튼1" event={clickEvent1}/>
      <Btn text="버튼2" event={() => {console.log('클릭'); count++; console.log(count)}}/>
      <Btn text="버튼3" event={() => consoleEvent(1)}/>
    </div>
  );
}
  export default App;