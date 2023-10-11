import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Insert(){
	// navigate를 이용해서 전송하는 코드 => location 'Home'에서 받아(왜?????ㅠㅠㅠ App.js에서 받으려다가 급 바꿔버림...)
	const navigate = useNavigate();

	// state변수 = 입력한 값 가져오기 위해서 만듦
	const [num, setNum] = useState(1);
	const [title, setTitle] = useState('');
	const [writer, setWriter] = useState('');

	// insert는 왜 그냥 Insert에서 하지??
	// 전송 준비가 끝이래.......why.....rano.....
	const insertBoard = () => {
		navigate('/', {
			state : {
				num : num,
				title : title,
				writer : writer
			}
		})
	}
	// onChange 있는 함수들 추가! (이제 왜 타겟.벨류 인지도 설명 안하는 구만...;)
	const numChange = (e) => {setNum(e.target.value)};
	const titleChange = (e) => {setTitle(e.target.value)};
	const writerChange = (e) => {setWriter(e.target.value)};

	return (
		<div>
			<input type="number" placeholder='게시글 번호' onChange={numChange} value={num}/>
			<br/>
			<input type="text" placeholder='게시글 제목' onChange={titleChange} value={title}/>
			<br/>
			<input type="text" placeholder='작성자' onChange={writerChange} value={writer}/>
			<br/>
			<button onClick={insertBoard}>등록</button>
		</div>
	)
}

export default Insert;