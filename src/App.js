import React, { Component } from 'react';
import {BrowserRouter as Router,Switch,Route,Link} from "react-router-dom";
import './App.css';
import {Tabs,Container,Tab,Navbar,Nav} from 'react-bootstrap'
import Home from './app/components/Home';
import Profile from './app/components/Profile';
import UserPage from './app/components/UserPage';
import ProjectManagerPage from './app/components/ProjectManagerPage';
import SignUp from './app/components/SignUp';
import AdminPage from './app/components/AdminPage';
import Login from './app/components/Login';
import ListUsersComponent from './app/Allusers/ListUsersComponent';
import CreateUserComponent from './app/Allusers/CreateUserComponent';
import ViewUserComponent from './app/Allusers/ViewUserComponent';
import UpdateUserComponent from './app/Allusers/UpdateUserComponent';
import ListModulesComponent from './app/modules/ListModulesComponent';


import AuthenticationService from './app/services/AuthenticationService';

class App extends Component {
  constructor(props){
    super(props);
    this.logOut= this.logOut.bind(this);

    this.state ={
        currentUser: undefined
    };

}

logOut(){
  AuthenticationService.logOut();
}

componentDidMount() {
    const user= AuthenticationService.getCurrentUser();
    console.log(user);

    if(user){
        this.setState({
            currentUser: AuthenticationService.getCurrentUser()
        })
    }
}

render(){
    const {currentUser} = this.state;
return (

<div className="App">



    <Router>
    <Container>
        <Navbar bg="dark" variant="dark">

            <Nav className="mr-auto" style={{textAlign: 'right'}}>


                {currentUser ? (
                        <div className="navbar-nav ml-auto">
                        <li className="nav-link">{currentUser.username}</li>
                            <a href="/" onClick={this.logOut} className="nav-link">Log out</a>
                        </div>

                    ):(
                        <div className="navbar-nav ml-auto">
                            < Link to={""} className="nav-link">AdminLogin</Link>
                            <Link to={"studentLogin"} className="nav-link">Student Login</Link>
                            <Link to={"lecturerLogin"} className="nav-link">Lecturer Login</Link>
                        </div>


                    )}
            </Nav>

        </Navbar>


      


            <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/home' exact={true} component={Home}/>
          <Route path='/profile' exact={true} component={Profile}/>
          <Route path='/user' exact={true} component={UserPage}/>
          <Route path='/pm' exact={true} component={ProjectManagerPage}/>
          <Route path='/admin' exact={true} component={AdminPage}/>
          <Route path='/signin' exact={true} component={Login}/>
          <Route path='/signup' exact={true} component={SignUp}/>  

          <Route path = "/users" component = {ListUsersComponent}></Route>
          <Route path = "/add-user" component = {CreateUserComponent}></Route>
          <Route path = "/view-user/:id" component = {ViewUserComponent}></Route>
          <Route path = "/update-user/:id" component = {UpdateUserComponent}></Route>

          <Route path = "/modules" component = {ListModulesComponent}></Route>             


        </Switch>
        </Container>
      </Router>

      </div>
    )
  }
}

export default App;