/**
 * Created by benjamin on 06.01.2016.
 */
describe("QuestionnairController", function() {

    beforeEach(module('flashcard'));

    var ctrl;

    beforeEach(inject(function($controller){
        // The injector unwraps the underscores (_) from around the parameter names when matching
        ctrl = $controller('QuestionnaireController');
    }));

    it('should create "questionnaires" model with 3 questionnaires', function() {
        expect(ctrl.questionnaires.length).toBe(3);
        var q = ctrl.questionnaires[0];
        expect(q.id).toBe(1);
        expect(q.title).toBe('Q1');
        expect(q.description).toBe('Lorem ipsum...');

    });
    it('should add new questionnaire', function() {
        ctrl.mytitle = "Test";
        ctrl.add();

        expect(ctrl.questionnaires.length).toBe(4);
        var q = ctrl.questionnaires[3];
        expect(q.id).toBe(4);
        expect(q.title).toBe('Test');
    });
    it('should remove questionnaire', function() {
        ctrl.remove(1);

        expect(ctrl.questionnaires.length).toBe(2);
        var q = ctrl.questionnaires[0];
        expect(q.id).toBe(2);
        expect(q.title).toBe('Q2');
    });
});