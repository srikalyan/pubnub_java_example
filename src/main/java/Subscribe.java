import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.pubnub.api.PubnubException;

/**
 * @author srikalyan.swayampakula
 */
public class Subscribe {
   public static void main(String[] args) {
      final Pubnub pubnub = new Pubnub("demo", "demo");

      try {
         pubnub.subscribe(
            "my.*",
            new Callback() {
               @Override
               public void connectCallback(String channel, Object message) {
                  pubnub.publish("my_channel", "Hello from the PubNub Java SDK",
                                 new Callback() {});
               }

               @Override
               public void disconnectCallback(String channel, Object message) {
                  System.out.println("SUBSCRIBE : DISCONNECT on channel:" + channel
                                     + " : " + message.getClass() + " : "
                                     + message.toString());
               }

               public void reconnectCallback(String channel, Object message) {
                  System.out.println("SUBSCRIBE : RECONNECT on channel:" + channel
                                     + " : " + message.getClass() + " : "
                                     + message.toString());
               }

               @Override
               public void successCallback(String channel, Object message) {
                  System.out.println("SUBSCRIBE : " + channel + " : "
                                     + message.getClass() + " : " + message
                                        .toString());
               }

               @Override
               public void errorCallback(String channel, PubnubError error) {
                  System.out.println("SUBSCRIBE : ERROR on channel " + channel
                                     + " : " + error.toString());
               }
            }
         );
      } catch (PubnubException e) {
         System.out.println(e.toString());
      }
   }
}
