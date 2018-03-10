export class Routes {
    static LOGIN: String = 'user/login';
    static REGISTER: String = 'user/register';
    static LOGOUT: String = 'user/logout';
    static UPLOAD: String = 'upload/getallfiles';
    static UPLOADASD: String = 'upload/post';
    static PICTURE: String = 'upload/files/';
    static WORKERS: String = '/user/workers';
    static CART: String = 'cart';
    static ORDERS: String = 'orders';
  }
  
  export class Server {
    private static address: String = 'localhost';
    private static port: String = '4200';
    private static prefix: String = 'api';
  
    static routeTo(route: String) {
      return `http://${Server.address}:${Server.port}/${Server.prefix}/${route}`
    }
  }