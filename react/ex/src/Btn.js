function Btn({text, event, click}){
	// const count = () => {
	// 	let [count, setCount] = useState();
	// 	setCount += count;
	// }
	return (
    <button onClick={event}>{text}</button>
    )  
  }

	export default Btn;

// 2. Btn 컴포넌트를 Btn.js 파일에 옮겨서 작성
// -> export/import 해줘야함

