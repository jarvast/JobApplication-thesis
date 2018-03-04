export class Routes {
    static LOGIN: String = 'user/login';
    static REGISTER: String = 'user/register';
    static LOGOUT: String = 'user/logout';
    static ISSUES: String = 'issues';
    static CATEGORIES: String = 'categories';
    static ITEMS: String = 'items';
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