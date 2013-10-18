$(document).ready(function(){
	
	window.Product = Backbone.Model.extend({});
	
	window.Products = Backbone.Collection.extend({
		model: Product,
		url: '/backbone-1.0/products.do'
	});
	
	window.products = new Products();
	
	window.ProductView = Backbone.View.extend({
		tagName: 'li',
		className: 'product',
		
		initialize:function(){
			_.bindAll(this,'render');
			this.template = _.template($('#product-template').html());
			this.model.bind('change',this.render);
		},
		
		render:function(){
			var renderContent = this.template(this.model.toJSON());
			$(this.el).html(renderContent);
			return this;
		}
	});
	
	window.ProductsListView = ProductView.extend();
	
	window.ProductsView = Backbone.View.extend({
		
		tagName: 'section',
		className: 'products-list',
		
		initialize:function(){
			_.bindAll(this,'render');
			this.template = _.template($('#products-template').html());
			this.collection.bind('reset',this.render);
		},
		
		render:function(){
			var $products,
				collection = this.collection;
			$(this.el).html(this.template({}));
			$products = this.$('.products');
			collection.each(function(product){
				var view = new ProductsListView({
					model: product,
					collection: collection
				});
				$products.append(view.render().el);
			});
			return this;
		}
		
		
	});
	
	window.ProductApp = Backbone.Router.extend({
		routers:{
			'':'home'
		},
	
		initialize:function(){
			this.productsView = new ProductsView({collection: window.products});
		},
		
		home:function(){
			var $container = $('#product-container');
			$container.empty();
			$container.append(this.productsView.render().el);
		}
		
	});
	
	
	$(function(){
		products.fetch();
		window.App = new ProductApp();
		window.App.home();		
	});
	
});