package com.newlecture.web.service.newlec;

import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.jdbc.JdbcNoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

public class NewlecNoticeService implements NoticeService {

	private NoticeDao noticeDao; // Entity�� ��ġ ��Ų��.
	// �����ͺ��̽��� ����ϴ� ���� Table�� �̸��� ��ġ��Ų��.

	public NewlecNoticeService() {
		noticeDao = new JdbcNoticeDao();
	}

	@Override
	public int insertNotice(Notice notice) {

		return noticeDao.insert(notice);

		// String sql = "insert into ";
		// ���� �ڹٸ� �̿��� ����ó���� �ϴ� ������
		// �����ͺ��̽� ���α׷� �ִ� ���� �ƴϴ�.
		// ������ �ҽ��� ����� ������ Dao�� ����� ������..
		// ���⼭ ������ �ҽ��� ���� ��ü�� �ƴ� ���� �� ���� ����
	}

	@Override
	public List<NoticeView> getNoticeList() {
		// TODO Auto-generated method stub
		return getNoticeList(1, "title", "");
	}

	@Override
	public List<NoticeView> getNoticeList(int page) {
		// TODO Auto-generated method stub
		return getNoticeList(page, "title", "");
	}

	@Override
	public List<NoticeView> getNoticeList(int page, String field, String query) {
		return noticeDao.getList(page, field, query);
	}

	@Override
	public int openNoticeList(int[] ids) {
		int i = 0;

		i = noticeDao.openList(ids);
//		for (; i < ids.length; i++) {
//			Notice notice = noticeDao.get(ids[i]);
//			notice.setOpen(true);
//			noticeDao.update(notice);
//		}
		return i;
	}

	@Override
	public int deleteNoticeList(int[] ids) {
		int i = 0;

		for (; i < ids.length; i++)
			noticeDao.delete(ids[i]);

		return i;
	}

	@Override
	public Notice getNoticeById(int id) {

		return noticeDao.get(id);
	}

	@Override
	public Notice getPrevNoticeByCurrentId(int id) {

		return noticeDao.getPrevById(id);
	}

	@Override
	public Notice getNextNoticeByCurrentId(int id) {

		return noticeDao.getNextById(id);
	}

	@Override
	public int updateNotice(Notice notice) {
		
		return noticeDao.update(notice);
	}

	@Override
	public int deleteNotice(int id) {

		return noticeDao.delete(id);
	}

	@Override
	public int getNoticeListCount(String field, String query)
	{
		// TODO Auto-generated method stub
		return noticeDao.getListCount(field, query);
	}
}