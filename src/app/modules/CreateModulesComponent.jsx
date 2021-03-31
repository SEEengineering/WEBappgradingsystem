import React, { Component } from 'react';
import UserService from '../services/UserService';
import {Drawer, Input, Col, Select, Form, Row, Button, Spin} from 'antd';
const {Option} = Select;
class CreateUserComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: '',
            name: '',
            Lastname: '',
            email: '',
            phone: '',
            address:'',
            sex:'',
            role:''


        }
        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeFistNameHandler = this.changeFistNameHandler.bind(this);
        this.changeLastnameHandler = this.changeLastnameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.changeSexHandler = this.changeSexHandler.bind(this);
        this.changeRoleHandler = this.changeRoleHandler.bind(this);
        this.saveUser = this.saveUser.bind(this);
    }




    saveUser = (e) =>{
        e.preventDefault();
        let user = {id: this.state.id, name: this.state.name, lastname: this.state.lastname, email: this.state.email,
        address: this.state.address, sex: this.state.sex, role: this.state.role};
        console.log('user => ' +JSON.stringify(user));

        UserService.addUser(user)
        

    }
    changeIdHandler=(event) =>{
        this.setState({id: event.target.value});
    }
    changeFistNameHandler=(event) =>{
        this.setState({name: event.target.value});
    }
    changeLastnameHandler=(event) =>{
        this.setState({lastname: event.target.value});
    }
    changeEmailHandler=(event) =>{
        this.setState({email: event.target.value});
    }
    changePhoneHandler=(event) =>{
        this.setState({phone: event.target.value});
    }
    changeAddressHandler=(event) =>{
        this.setState({address: event.target.value});
    }
    changeSexHandler=(event) =>{
        this.setState({sex: event.target.value});
        
    }
    changeRoleHandler=(event) =>{
        this.setState({role: event.target.value});
    }

   
   
    render() {
        return (
            <div>
                    <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 oofset-md-3 offset-md-3">
                                <h3 className="text-center">Add Employee</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className= "form-group">
                                            <label>ID</label>
                                            <input placeholder="ID" name="id" className="form-control"
                                            value={this.state.id} onChange={this.changeIdHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>First Name</label>
                                            <input placeholder="First Name" name="name" className="form-control"
                                            value={this.state.name} onChange={this.changeFistNameHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>Last Name</label>
                                            <input placeholder="Last Name" name="lastname" className="form-control"
                                            value={this.state.lastname} onChange={this.changeLastnameHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>Email</label>
                                            <input placeholder="Email" name="email" className="form-control"
                                            value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>Phone</label>
                                            <input placeholder="Phone" name="phone" className="form-control"
                                            value={this.state.phone} onChange={this.changePhoneHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>Address</label>
                                            <input placeholder="Address" name="address" className="form-control"
                                            value={this.state.address} onChange={this.changeAddressHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>Sex</label>
                                         
                                            <input placeholder="Sex" name="sex" className="form-control"
                                            
                                            value={this.state.sex} onChange={this.changeSexHandler}/>
                                        </div>
                                        <div className= "form-group">
                                            <label>Role</label>
                                            <input placeholder="Role" name="role" className="form-control"
                                            value={this.state.role} onChange={this.changeRoleHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveUser}>save</button>
                                    
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        );
    }
}

export default CreateUserComponent;