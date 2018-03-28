export class Routes {
    static LOGIN: String = 'user/login';
    //static REGISTER: String = 'user/register';
    static LOGOUT: String = 'user/logout';
    //static UPLOAD: String = 'upload/getallfiles';
    static UPLOADFILE: String = 'upload/post';
    static PICTURE: String = 'upload/files/';
    static ALLWORKERS: String = 'user/workers';
    static SEARCHWORKERS: String = 'user/workers/search';
    static SINGLEWORKER: String = 'user/worker';
    static SINGLEUSER: String = 'user/user';
    static CATEGORIES: String = 'categories';
    static RATING: String = 'ratings';
    static LOCATION: String = 'location';
    static TASKSBYUSER: String = 'tasks';
    static UPDATETASK: String = 'tasks/update';
    static NEWTASK: String = 'tasks/create';
    static FAVORITE: String = 'user/favorite';
  }
  
  export class Server {
    private static address: String = 'localhost';
    private static port: String = '4200';
    private static prefix: String = 'api';
  
    static routeTo(route: String) {
      return `http://${Server.address}:${Server.port}/${Server.prefix}/${route}`
    }
  }