package acowerks.correncymaster;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Aleksandar Dobrinić on 17.3.2016..
 */
public class GetCurrency {

    @SerializedName("list")
    @Expose
    private List list;

    /**
     * @return The list
     */
    public List getList() {
        return list;
    }

    /**
     * @param list The list
     */
    public void setList(List list) {
        this.list = list;
    }

    public class List {

        @SerializedName("meta")
        @Expose
        private Meta meta;
        @SerializedName("resources")
        @Expose
        private java.util.List<Resource> resources = new ArrayList<Resource>();

        /**
         *
         * @return
         * The meta
         */
        public Meta getMeta() {
            return meta;
        }

        /**
         *
         * @param meta
         * The meta
         */
        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        /**
         *
         * @return
         * The resources
         */
        public java.util.List<Resource> getResources() {
            return resources;
        }

        /**
         *
         * @param resources
         * The resources
         */
        public void setResources(java.util.List<Resource> resources) {
            this.resources = resources;
        }

        public class Meta {

            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("start")
            @Expose
            private Integer start;
            @SerializedName("count")
            @Expose
            private Integer count;

            /**
             *
             * @return
             * The type
             */
            public String getType() {
                return type;
            }

            /**
             *
             * @param type
             * The type
             */
            public void setType(String type) {
                this.type = type;
            }

            /**
             *
             * @return
             * The start
             */
            public Integer getStart() {
                return start;
            }

            /**
             *
             * @param start
             * The start
             */
            public void setStart(Integer start) {
                this.start = start;
            }

            /**
             *
             * @return
             * The count
             */
            public Integer getCount() {
                return count;
            }

            /**
             *
             * @param count
             * The count
             */
            public void setCount(Integer count) {
                this.count = count;
            }
        }



        public class Resource {

            @SerializedName("resource")
            @Expose
            private Resource_ resource;

            /**
             *
             * @return
             * The resource
             */
            public Resource_ getResource() {
                return resource;
            }

            /**
             *
             * @param resource
             * The resource
             */
            public void setResource(Resource_ resource) {
                this.resource = resource;
            }

            public class Resource_ {

                @SerializedName("classname")
                @Expose
                private String classname;
                @SerializedName("fields")
                @Expose
                private Fields fields;

                /**
                 *
                 * @return
                 * The classname
                 */
                public String getClassname() {
                    return classname;
                }

                /**
                 *
                 * @param classname
                 * The classname
                 */
                public void setClassname(String classname) {
                    this.classname = classname;
                }

                /**
                 *
                 * @return
                 * The fields
                 */
                public Fields getFields() {
                    return fields;
                }

                /**
                 *
                 * @param fields
                 * The fields
                 */
                public void setFields(Fields fields) {
                    this.fields = fields;
                }


                public class Fields {

                    @SerializedName("name")
                    @Expose
                    private String name;
                    @SerializedName("price")
                    @Expose
                    private String price;
                    @SerializedName("symbol")
                    @Expose
                    private String symbol;
                    @SerializedName("ts")
                    @Expose
                    private String ts;
                    @SerializedName("type")
                    @Expose
                    private String type;
                    @SerializedName("utctime")
                    @Expose
                    private String utctime;
                    @SerializedName("volume")
                    @Expose
                    private String volume;

                    /**
                     *
                     * @return
                     * The name
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     *
                     * @param name
                     * The name
                     */
                    public void setName(String name) {
                        this.name = name;
                    }

                    /**
                     *
                     * @return
                     * The price
                     */
                    public String getPrice() {
                        return price;
                    }

                    /**
                     *
                     * @param price
                     * The price
                     */
                    public void setPrice(String price) {
                        this.price = price;
                    }

                    /**
                     *
                     * @return
                     * The symbol
                     */
                    public String getSymbol() {
                        return symbol;
                    }

                    /**
                     *
                     * @param symbol
                     * The symbol
                     */
                    public void setSymbol(String symbol) {
                        this.symbol = symbol;
                    }

                    /**
                     *
                     * @return
                     * The ts
                     */
                    public String getTs() {
                        return ts;
                    }

                    /**
                     *
                     * @param ts
                     * The ts
                     */
                    public void setTs(String ts) {
                        this.ts = ts;
                    }

                    /**
                     *
                     * @return
                     * The type
                     */
                    public String getType() {
                        return type;
                    }

                    /**
                     *
                     * @param type
                     * The type
                     */
                    public void setType(String type) {
                        this.type = type;
                    }

                    /**
                     *
                     * @return
                     * The utctime
                     */
                    public String getUtctime() {
                        return utctime;
                    }

                    /**
                     *
                     * @param utctime
                     * The utctime
                     */
                    public void setUtctime(String utctime) {
                        this.utctime = utctime;
                    }

                    /**
                     *
                     * @return
                     * The volume
                     */
                    public String getVolume() {
                        return volume;
                    }

                    /**
                     *
                     * @param volume
                     * The volume
                     */
                    public void setVolume(String volume) {
                        this.volume = volume;
                    }

                }
            }
        }
    }
}
