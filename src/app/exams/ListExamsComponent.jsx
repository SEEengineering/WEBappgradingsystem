import React, { Component } from 'react'
import UserService from '../services/UserService'
import Table from 'react-bootstrap/Table'


class ListExamsComponent extends Component{
    constructor(props){
        super(props)

        this.state = {
            exams: []

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
        UserService.getExams().then((res) => {
            this.setState({exams: res.data});
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
                                    <th>Description</th>
                                    <th>moduleID</th>
                                    <th>examinerID</th>
                                    <th>Actions</th>
                                    
                                </tr>
                            </thead>

                            <tbody>
                                {

                                    this.state.exams.map(
                                        exam =>
                                        <tr key = {exam.id}>
                                            <td>{exam.id}</td>
                                            <td> {exam.description}</td>
                                            <td> {exam.moduleID}</td>
                                            <td> {exam.examinerID}</td>
                                            <td>
                                                <button onClick = { () =>this.editUser(exam.id)}className="btn btn-info">Update </button>
                                                <button style={{marginLeft: "10px"}} onClick = { () =>this.deleteUser(exam.id)}className="btn btn-danger">Delete </button>
                                               

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

export default ListExamsComponent