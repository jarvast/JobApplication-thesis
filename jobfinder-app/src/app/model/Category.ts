export class Category {
    categoryName: String;
    picture: String;

    
  constructor(categoryName?: String, picture?: String) {
    this.categoryName = categoryName || "";
    this.picture = picture || "";
    }
}