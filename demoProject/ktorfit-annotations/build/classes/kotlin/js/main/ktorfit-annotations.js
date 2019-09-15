(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'ktorfit-annotations'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'ktorfit-annotations'.");
    }
    root['ktorfit-annotations'] = factory(typeof this['ktorfit-annotations'] === 'undefined' ? {} : this['ktorfit-annotations'], kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Annotation = Kotlin.kotlin.Annotation;
  function GET(url) {
    this.url = url;
  }
  GET.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'GET',
    interfaces: [Annotation]
  };
  var package$de = _.de || (_.de = {});
  var package$jensklingenberg = package$de.jensklingenberg || (package$de.jensklingenberg = {});
  var package$ktofitAnnotations = package$jensklingenberg.ktofitAnnotations || (package$jensklingenberg.ktofitAnnotations = {});
  package$ktofitAnnotations.GET = GET;
  Kotlin.defineModule('ktorfit-annotations', _);
  return _;
}));

//# sourceMappingURL=ktorfit-annotations.js.map
