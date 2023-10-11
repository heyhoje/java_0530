import React from 'react'
import { useState } from 'react'
import { useLocation } from 'react-router-dom'

function Home({list, deleteBoard, add} ){
	// {list} 부모가 보내준 props값은 자식에서는 수정이 안됨.
	// const deleteBoard = () => {} (x)
	// => 부모한테 다시 삭제해달라고 요청해야함! help me!!

	const location = useLocation();
	// 객체..하... 이제 진짜 모르겠다 포기한 이유가 있었다
	let board = location.state;
	if(board != null){
		add(board); // add board는 밖에서 알려줄거야 => 그래서 {} 안에 써준대.. 응 그렇대...
		location.state = null;
	}
	return(
		<main>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>기능</th>
					</tr>
				</thead>
				<tbody>
					{list.length == 0 ? 
					//list.length는 속성이라 ()를 붙여서 함수로 만들면 안됨.}
					<tr><td colSpan={4}><h1>등록된 게시물이 없습니다.</h1></td></tr> : 
					list.map(item => {
						// {list} 부모가 보내준 컨퍼넌트를 map을 통해서 요소로 화면에 뿌려줄 수 있음 ex) to do 예제!
						// * return 빠지면 안됨. 그냥 {}를 하면, 리턴타입 없는 함수로 인식하기 때문이라는데 모르겠음
						return(
							// * Each child in a list should have a unique "key" prop.
						<tr key={item.num}>
							<td>{item.num}</td>
							<td>{item.title}</td>
							<td>{item.writer}</td> 
							<td><button onClick={() => {deleteBoard(item.num)}}>삭제</button></td>
						</tr>
						)
					})
					}
				</tbody>
			</table>
		</main>
	)
}

export default Home;