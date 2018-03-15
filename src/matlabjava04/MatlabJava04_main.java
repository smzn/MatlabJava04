package matlabjava04;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import com.mathworks.engine.MatlabExecutionException;
import com.mathworks.engine.MatlabSyntaxException;

public class MatlabJava04_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Future<MatlabEngine> eng = MatlabEngine.startMatlabAsync();
			MatlabEngine ml = eng.get();
			ml.eval("x = 0:pi/100:2*pi;");
			ml.eval("y = sin(x);");
			ml.eval("y2 = sin(x-.25);");
			ml.eval("y3 = sin(x-.5);");
			ml.eval("plot(x, y, x, y2, x, y3);");
			
			//plotのあと軸を追加
			ml.eval("xlabel('x = 0:2\\pi');");
			ml.eval("ylabel('Sine of x');");
			ml.eval("title('Plot of the Sine Function','FontSize',12);");
			ml.eval("legend('sin(x)','sin(x-.25)','sin(x-.5)')");
			ml.eval("saveas(gcf,'sample.png')");
			ml.eval("pause(30);");
			
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RejectedExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
