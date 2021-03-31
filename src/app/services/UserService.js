import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:8080/api/v1/users";
const MODULE_API_BASE_URL = "http://localhost:8080/api/v1/modules";
const EXAM_API_BASE_URL = "http://localhost:8080/api/v1/exams";
const GRADES_API_BASE_URL = "http://localhost:8080/api/v1/grades";

class UserService {

    getUsers(){
        return axios.get(USER_API_BASE_URL);
    }

    getModules(){
        return axios.get(MODULE_API_BASE_URL);
    }

    getExams(){
        return axios.get(EXAM_API_BASE_URL);
    }

    getGrades(){
        return axios.get(GRADES_API_BASE_URL);
    }



    addUser(user){
        return axios.post(USER_API_BASE_URL, user);
    }

    addModule(module){
        return axios.post(MODULE_API_BASE_URL, module);
    }

    addExam(exam){
        return axios.post(MODULE_API_BASE_URL, exam);
    }

    addGrade(grade){
        return axios.post(MODULE_API_BASE_URL, grade);
    }

    getGradeById(grade){
        return axios.get(GRADES_API_BASE_URL + '/' + grade);
    }


    getUserById(userId){
        return axios.get(USER_API_BASE_URL + '/' + userId);
    }

    updateUser(user, userId){
        return axios.put(USER_API_BASE_URL + '/' + userId, user);
    }

    deleteUser(userId){
        return axios.delete(USER_API_BASE_URL + '/' + userId);
    }
}

export default new UserService()