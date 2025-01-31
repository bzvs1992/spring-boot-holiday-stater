package cn.bzvs.holiday.autoconfigure;

import cn.bzvs.holiday.entity.vo.CalendarVO;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 常量数据
 *
 * @author bzvs
 * @date 2024/12/04
 * @since 1.0.0
 */
public class ConstantData {

  /** 所有日期数据 */
  private static final Map<String, CalendarVO> ALL_DATE_MAP = new ConcurrentHashMap<>();

  /**
   * 初始化，并设置数据
   *
   * @param calendarVOList 对象列表
   */
  public static void init(List<CalendarVO> calendarVOList) {
    ALL_DATE_MAP.clear();
    setDayInfoAll(calendarVOList);
  }

  /**
   * 设置数据
   *
   * @param calendarVOList 对象列表
   */
  public static void setDayInfoAll(List<CalendarVO> calendarVOList) {
    Map<String, CalendarVO> allMap =
        calendarVOList.stream().collect(Collectors.toMap(CalendarVO::getDate, Function.identity()));
    ALL_DATE_MAP.putAll(allMap);
  }

  /**
   * 获取所有日历数据
   *
   * @return Map<String, CalendarVO> 对象MAP
   */
  public static Map<String, CalendarVO> getAllDateMap() {
    return new ConcurrentHashMap<>(ALL_DATE_MAP);
  }
}
