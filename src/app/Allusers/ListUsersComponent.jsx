import React, { Component } from 'react'
import UserService from '../services/UserService'
import Table from 'react-bootstrap/Table'


class ListUsersComponent extends Component{
    constructor(props){
        super(props)

        this.state = {
            users: []

        }
        this.addUser = this.addUser.bind(this);
        this.editUser =this.editUser.bind(this);
        this.deleteUser =this.deleteUser.bind(this);
    }
    viewUser(id){
        this.props.history.push(`/view-user/${id}`);
    }
    deleteUser(id){
        UserService.deleteUser(id).then( res => {
            this.setState({users: this.state.users.filter(user => user.id !== id)});
        });

    }

    editUser(id){
        this.props.history.push(`/update-user/${id}`);

    }


    componentDidMount(){
        UserService.getUsers().then((res) => {
            this.setState({users: res.data});
        });
    }

    addUser(){
        this.props.history.push('/add-user');
    }

    render(){
        return(
            <div>
                 <h2 className = "text-center">Users List</h2>
                 <div className = "row">
                    
                 </div>
                    <div className = "row">
                    <Table striped bordered hover>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>name</th>
                                    <th>Last name</th>
                                    <th>email</th>
                                    <th>address</th>
                                    <th>phone</th>
                                    <th>role</th>
                                    <th>sex</th>
                                    <th>Actions</th>
                                    
                                </tr>
                            </thead>

                            <tbody>
                                {

                                    this.state.users.map(
                                        user =>
                                        <tr key = {user.id}>
                                            <td>{user.id}</td>
                                            <td> {user.name}</td>
                                            <td> {user.lastname}</td>
                                            <td> {user.email}</td>
                                            <td> {user.phone}</td>
                                            <td> {user.address}</td>
                                            <td> {user.role}</td>
                                            <td> {user.sex}</td>
                                            <td>
                                                <button onClick = { () =>this.editUser(user.id)}className="btn btn-info">Update </button>
                                                <button style={{marginLeft: "10px"}} onClick = { () =>this.deleteUser(user.id)}className="btn btn-danger">Delete </button>
                                                <button style={{marginLeft: "10px"}} onClick = { () =>this.viewUser(user.id)}className="btn btn-info">View </button>

                                            </td>
                                        </tr>
                                    )
                                }


                            </tbody>


                        </Table>


                    </div>

            </div>



        )
    }

}

export default ListUsersComponent