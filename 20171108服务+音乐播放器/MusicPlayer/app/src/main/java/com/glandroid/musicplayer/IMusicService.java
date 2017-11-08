package com.glandroid.musicplayer;

import java.util.List;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public interface IMusicService {

    /**
     * 调用服务里面的播放逻辑
     *
     * @param playList
     *          音乐资源的路径集合
     * @param position
     */
    public void callPlay(List<String> playList, int position);

    /**
     * 调用停止播放的方法
     */
    public void callStop();

}
