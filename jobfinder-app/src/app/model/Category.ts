export class Category {
    categoryName: String;
    picture: String;
    id:number;

    
  constructor(categoryName?: String, picture?: String, id?:number) {
    this.categoryName = categoryName || "";
    this.picture = picture || "";
    this.id = id;
    }
}