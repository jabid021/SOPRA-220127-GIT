import { Directive, ElementRef, Renderer2, OnInit } from '@angular/core';

@Directive({
  selector: '[appDemo]',
})
export class DemoDirective implements OnInit {
  //@Input

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
    const div = this.renderer.createElement('div');
    const text = this.renderer.createText('generer par la directive');
    this.renderer.appendChild(div, text);
    this.renderer.appendChild(this.el.nativeElement, div);
  }
}
