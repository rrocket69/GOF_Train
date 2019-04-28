package Visitor;

public class VisitorController {
    public void startAction() {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor hooligan = new HooliganVisitor();
        Visitor mech = new MechanicVisitor();
        body.accept(hooligan);
        body.accept(mech);
        engine.accept(hooligan);
    }

    interface Visitor {
        void visit(EngineElement engineElement);

        void visit(BodyElement bodyElement);
    }

    interface Element {
        void accept(Visitor visitor);
    }

    class BodyElement implements Element {
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    class EngineElement implements Element {
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    class HooliganVisitor implements Visitor {

        @Override
        public void visit(EngineElement engineElement) {
            System.out.println("smash engine");
        }

        @Override
        public void visit(BodyElement bodyElement) {
            System.out.println("smash corpus");
        }
    }

    class MechanicVisitor implements Visitor {


        @Override
        public void visit(EngineElement engineElement) {
            System.out.println("fix engine");
        }

        @Override
        public void visit(BodyElement bodyElement) {
            System.out.println("fix corpus");
        }
    }
}
