'use strict';

// Alternative implementation. No changes on the client-side are needed!
// Create the factory as Closure!
angular.module('flashcard').factory('QuestionnaireRepository', function() {
	// Keep 'questionnaires' hidden to the rest of the world.
	var questionnaires = [
		 {id:1, title: 'Q1', description: 'Lorem ipsum...'},
		 {id:2, title: 'Q2', description: 'Lorem ipsum...'},
		 {id:3, title: 'Q3', description: 'Lorem ipsum...'}
	];
	
	var index = questionnaires.length;
	
	function findById(id) {
		var index = -1;
//		for (var i=0; i < questionnaires.length; i++) {
//			var questionnaire = questionnaires[i];
//			if (questionnaire.id === id) {
//				index = i;
//			}
//		}
		questionnaires.forEach(function(questionnaire, i) {
			if (questionnaire.id === id) {
				index = i;
				return;
			};
		});
		return index;
	};
	
	/*
	 * Return a function object with public methods. 
	 * Only these methods have access to the instance variables.
	 * This is the public API!
	 */
	return {
		getAll : function() {
			return questionnaires;
		},
		add : function(mytitle) {
			var questionnaire = {id:++index, title: mytitle, description: 'Lorem ipsum...'};
			questionnaires.push(questionnaire);
		},
		remove : function(id) {
			var index = findById(id);
			questionnaires.splice(index,1);
		},
		save : function(questionnaire) {
			questionnaire.id = ++index;
			questionnaires.push(questionnaire);
		},
		getById : function(id) {
			var index = findById(id);
			return questionnaires[index];
		},
		update : function(questionnaire) {
			var index = findById(questionnaire.id);
			questionnaires[index].title = questionnaire.title;
			questionnaires[index].description = questionnaire.description;
		}		
	};
});