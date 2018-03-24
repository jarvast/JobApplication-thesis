import { Directive } from '@angular/core';

@Directive({
  selector: '[no-cache-src]'
})
export class NocacheDirective {

  constructor() { }

}
