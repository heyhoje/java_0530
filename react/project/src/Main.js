import { useState } from "react";

function Main(){
	let [page, setPage] = useState(1); // [0, f]
	const maxPage = 13;
	// console.log('렌더링', page);

	// function함수는 컨포넌트 만들때, 이벤트는 const로 만드는 걸 추천
	const leftBtnClick = () => {
		setPage(page == 1 ? maxPage : page - 1);
		// console.log('클릭', page)
	}
	const rightBtnClick = () => {
		setPage(page == maxPage ? 1 : page + 1);
	}
  return(
    <main>
			<div>
				<button onClick={leftBtnClick}> - </button>
				<span> {page} / {maxPage} </span>
				<button onClick={rightBtnClick}> + </button>
			</div>
		</main>
  )
}

export default Main;