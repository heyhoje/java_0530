import React from 'react';
import './index.css';
import { Link } from 'react-router-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

function Header(){
	return(
		<header className='menu'>
			<ul className='menu-list'>
				<li className='menu-item'>
					<Link to="/" className='menu-link'>List</Link>
				</li>
				<li>
					<Link to="/insert" className='menu-link'>Add New Moive</Link>
				</li>
			</ul>
		</header>
	)
}

function Home({deleteMovie, add}){
	const location = useLocation();
  const [list, setList] = useState([]);
	
	let movie = location.state;
	if(movie != null){
		add(movie);
		location.state = null;
	}

  return (
    <main>
      <h1>Movies</h1>
			<table className="box">
				<thead className="box-list">
					<tr className="box-item">
						<th>ID</th>
						<th>title</th>
						<th>Genre</th>
						<th>Release Date</th>
            <th>Action</th>
					</tr>
				</thead>
				<tbody className="box-list">
          {list.length == 0 ? 
            <tr><td colSpan={5}><h1>No Movie Information</h1></td></tr> : 
            list.map(item => {
              return (
              <tr key={item.id} className="box-item">
                <td>{item.id}</td>
                <td>{item.title}</td>
                <td>{item.genre}</td> 
                <td>{item.releaseDate}</td> 
                <td><button onClick={() => {deleteMovie(item.id)}}>삭제</button></td>
              </tr>
              )
            })
            }
				</tbody>
			</table>
		</main>
  )
}

function Insert(){
  const navigate = useNavigate();

	const [id, setId] = useState();
	const [title, setTitle] = useState('');
	const [genre, setGenre] = useState('');
  const [releaseDate, setReleaseDate] = useState('');

	const insertMovie = (id, title, genre, releaseDate) => {
		navigate('/', {
			state : {
				id : id,
				title : title,
				genre : genre,
        releaseDate : releaseDate
			}
		})
	}
	
	const idChange = (e) => {setId(e.target.value)};
	const titleChange = (e) => {setTitle(e.target.value)};
	const genreChange = (e) => {setGenre(e.target.value)};
  const releaseDateChange = (e) => {setReleaseDate(e.target.value)};


 return(
  <body>
   <div>
      <h1>Create Movie</h1>
      <input type="text" onChange={idChange} placeholder="Input movie Id" value={id}/><br/>
      <input type="text" onChange={titleChange} placeholder="Input movie title" value={title}/><br/>
      <input type="text" onChange={genreChange} placeholder="Input movie genre" value={genre}/><br/>
    </div>
    <div>
      <h3>출시일:</h3><span><input type="date" onChange={releaseDateChange} value={releaseDate}/></span><br/>
      <button onClick={insertMovie}>Add Movie</button>
    </div>
  </body>
 )
}


function App() {
  let [list, setList] = useState([{
    id : 1,
    title : 'Movie 1',
    genre : 'Drama',
    releaseDate : '2022-01-01'
  }, {
    id : 2,
    title : 'Movie 2',
    genre : 'Action',
    releaseDate : '2022-02-01'
  }, {
    id : 3,
    title : 'Movie 3',
    genre : 'Comedy',
    releaseDate : '2022-03-01'
  }
  ]);

  const deleteMovie = (id) => {
    let tmpList = list.filter(item => item.id != id); 
    setList(tmpList);
  }

  const addMovie = (movie) => {
    setList([movie, ...list]); 
  }

  return (
    <BrowserRouter>
      <Header/>
      <Routes>
        <Route path="/" exact element={<Home />} />
        <Route path='/insert' element={<Insert list={list} deleteMovie={deleteMovie} add={addMovie}/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App;
