import Header from "./Header";
import Main from "./Main";
import Main2 from "./Main2";
import Main3 from "./Main3";
import Footer from "./Footer";
import {BrowserRouter , Route, Routes} from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Header/>
        <Routes>
          <Route path="/" exact element={<Main/>}></Route>
          <Route path="/menu2" element={<Main2/>}></Route>
          <Route path="/menu3" element={<Main3/>}></Route>
        </Routes>
        <Footer/>
      </div>
    </BrowserRouter>
  );
}

export default App;
