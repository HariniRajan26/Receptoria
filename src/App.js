// import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
// import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddUser from './users/AddUser';
import ExistUser from './users/ExistUser';
import Recipe from './pages/Recipe';
import EditUser from './users/EditUser';
import DeleteUser from './users/DeleteUser';
import Main from './pages/Main';

function App() {
  return (
    <div className="App">
      <Router>
      {/* <Navbar/> */}
      <Routes>
        <Route exact path="/" element={<Main/>}/>
        <Route exact path="/login" element={<ExistUser/>}/>
        <Route exact path="/recipe" element={<Recipe/>}/>
        <Route exact path="/users" element={<Home/>}/>
        <Route exact path="/addUser" element={<AddUser/>}/>
        <Route exact path="/editUser/:userId" element={<EditUser/>}/>
        <Route exact path="/checkUser" element={<ExistUser/>}/>
        <Route exact path="/deleteUser/:userId" element={<DeleteUser/>}/>
      </Routes>

      </Router>
    </div>
  );
}

export default App;