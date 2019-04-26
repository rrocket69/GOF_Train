package Adapter;

public class AdapterController {
    public void startAction() {
        new VectorAdapterFromRaster().drawLine();
    }

    interface VectorGraphicsInterface {
        void drawLine();

        void drawSquare();
    }

    class RasterGraph {
        void drawRasterLine() {
            System.out.println("rastline");
        }

        void drawRasterSquare() {
            System.out.println("rastsquare");
        }
    }

    class VectorAdapterFromRaster extends RasterGraph implements VectorGraphicsInterface {

        public void drawLine() {
            drawRasterLine();
        }

        public void drawSquare() {
            drawRasterSquare();
        }
    }

    class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
        RasterGraph rasterGraph = new RasterGraph();

        public void drawLine() {
            rasterGraph.drawRasterLine();
        }

        public void drawSquare() {
            rasterGraph.drawRasterSquare();
        }
    }
}
