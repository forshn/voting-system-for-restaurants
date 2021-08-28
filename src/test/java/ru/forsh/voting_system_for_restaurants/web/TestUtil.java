//public class TestUtil {
//    public static String getContent(MvcResult result) throws UnsupportedEncodingException {
//        return result.getResponse().getContentAsString();
//    }
//
//    public static <T> T readFromJson(ResultActions action, Class<T> clazz) throws UnsupportedEncodingException {
//        return JsonUtil.readValue(getContent(action.andReturn()), clazz);
//    }
//
//    public static <T> T readFromJsonMvcResult(MvcResult result, Class<T> clazz) throws UnsupportedEncodingException {
//        return JsonUtil.readValue(getContent(result), clazz);
//    }
//
//    public static <T> List<T> readListFromJsonMvcResult(MvcResult result, Class<T> clazz) throws UnsupportedEncodingException {
//        return JsonUtil.readValues(getContent(result), clazz);
//    }
//
//    public static void mockAuthorize(User user) {
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken(new AuthorizedUser(user), null, user.getRoles()));
//    }
//
//    public static RequestPostProcessor userHttpBasic(User user) {
//        return SecurityMockMvcRequestPostProcessors.httpBasic(user.getEmail(), user.getPassword());
//    }
//
//    public static RequestPostProcessor userAuth(User user) {
//        return SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//    }
//}