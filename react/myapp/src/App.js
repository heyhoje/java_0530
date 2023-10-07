import './App.css';
import Menu from './Menu.js';
import Footer from './Footer.js';
import Body from './Body.js';

function App(){
  return(
    <div>
      <Menu/>
      <Body/>
      <Footer/>
    </div>
  );
}

export default App;

// // 어떻게 삼분할 메뉴 만들더라.. 호버까지 가지도 못하겠네 

// <style>
// /* 메뉴는 nav-ul=li-a태그 순으로 많이 쓰임. 구조 외워두면 좋음 */
//   .menu-list{
//     list-style: none; padding: 0; margin: 0; 
//     display: flex; list-style: none;
//   }
// </style>
  
// // 그럼 상단 메뉴부터가 App에 바로 작업한게 아니라 각각의 js/css로 분리생성하면서 시작된건가?
// // js는 js니까 css style속성?이 안먹혀서????? 
// function App() {
//   return (
//     <nav>
//       <ul className='menu-list'>
//         <li className='menu-item'>
//           <a className='menu-link' href='#'>메뉴1</a>
//         </li>
//         <li className='menu-item'>
//           <a className='menu-link' href='#'>메뉴2</a>
//         </li>
//         <li className='menu-item'>
//           <a className='menu-link' href='#'>메뉴3</a>
//         </li>
//       </ul>
//     </nav>

//   );
// }


