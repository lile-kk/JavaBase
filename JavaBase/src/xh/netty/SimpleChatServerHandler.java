package xh.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
/**
 * 
 * @author Administrator
 *�� handler ������������ʵ�ֿ�ʼ��handler ���� Netty ������������ I/O �¼��ġ�
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String>{

	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		for(Channel channel : channels){
			channel.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " join in \n");
		}
		channels.add(ctx.channel());
	}
	
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		for(Channel channel : channels){
			channel.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + "leave \n");
		}
		channels.remove(ctx.channel());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String s)
			throws Exception {
		// TODO Auto-generated method stub
		Channel incoming = ctx.channel();
		for (Channel channel : channels) {
			if(channel != incoming)
				channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + s + "\n");
			else {
				channel.writeAndFlush("[you]" + s + "\n");
			}
		}
		
	}
	
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		Channel incoming = ctx.channel();
		System.out.println("SimpleChatClient: " + incoming.remoteAddress() + "on line");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception{
		Channel incoming = ctx.channel();
		System.out.println("SimpleChatClient: " + incoming.remoteAddress() + "off line");
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		Channel incoming = ctx.channel();
		System.out.println("SimpleChatClient : " + incoming.remoteAddress() + "�쳣");
		//�������쳣�͹ر�����
		cause.printStackTrace();
		ctx.close();
	}
	
	
}
