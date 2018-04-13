export class Routes {
    static LOGIN: String = 'user/login';
    static LOGOUT: String = 'user/logout';
    static UPLOADFILE: String = 'upload/post';
    static PICTURE: String = 'upload/files/';
    static ALLWORKERS: String = 'user/workers';
    static ALLUSERS: String = 'user/users';
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
    static MESSAGES: String = 'messages';
    static APPOINTMENTS: String = 'appointments';
    static NEW: String = 'user/new';
  }
  
  export class Server {
    private static address: String = 'localhost';
    private static port: String = '4200';
    private static prefix: String = 'api';
  
    static routeTo(route: String) {
      return `http://${Server.address}:${Server.port}/${Server.prefix}/${route}`
    }
  }