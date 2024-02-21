import http from "../http-common.js";

class UserDataService {
    create(data) {
       return http.post("/users", data);
    }
};

export default new UserDataService();