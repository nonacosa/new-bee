
import _ from 'lodash'
const protobuf = require("protobufjs");

let b64 = new Array(64)
let s64 = new Array(64)

export function goBack(vue) {
    vue.$router.go(-1)
}
export function sampleBackGroundColor() {
    let color_arr = [
        "is-orange",
        "is-bootstrap",
        "is-primary",
        "is-success",
        "is-info",
        "is-danger"
    ]
    return _.sample(color_arr)
}

export function EP(json) {
    for (var i = 0; i < 64;) {
        s64[b64[i] = i < 26 ? i + 65 : i < 52 ? i + 71 : i < 62 ? i - 4 : i - 59 | 43] = i++
    }


    if (_.isEmpty(json)) {
        return "";
    }
    var root = protobuf.Root.fromJSON(protobuf.common.get('google/protobuf/struct.proto'));
    var StructMessage = root.lookupType("google.protobuf.Struct");
    var postDataConverted = json2Struct(json);
    var message = StructMessage.fromObject(postDataConverted);
    var buf = StructMessage.encode(message).finish();
    // this.bufLen=buf.length;
    return base64Encode(buf, 0, buf.length);
}

export function json2Struct(jsonObj) {

    var structObj = {};
    var structObjTmp = {};
    if (typeof jsonObj === 'object') {
        structObjTmp = jsonObj;
    }

    Object.keys(structObjTmp).forEach(function (field) {
        var value = structObjTmp[field];
        switch (typeof (value)) {
            case 'number':
                structObj[field] = { numberValue: value };
                break;
            case 'string':
                structObj[field] = { stringValue: value };
                break;
            case 'boolean':
                structObj[field] = { boolValue: value };
                break;
            case 'object':
                // null
                if (!value) break;
                if (value.constructor === Object) {
                    structObj[field] = { structValue: PSMU.json2Struct(value) };
                } else if (value.constructor === Array) {
                    structObj[field] = { listValue: PSMU.json2List(value) };
                }
                break;
        }
    });
    return { fields: structObj };

}
export function base64Encode(buffer, start, end) {
    var parts = null,
        chunk = [];
    var i = 0, // output index
        j = 0, // goto index
        t;     // temporary
    while (start < end) {
        var b = buffer[start++];
        switch (j) {
            case 0:
                chunk[i++] = b64[b >> 2];
                t = (b & 3) << 4;
                j = 1;
                break;
            case 1:
                chunk[i++] = b64[t | b >> 4];
                t = (b & 15) << 2;
                j = 2;
                break;
            case 2:
                chunk[i++] = b64[t | b >> 6];
                chunk[i++] = b64[b & 63];
                j = 0;
                break;
        }
        if (i > 8191) {
            (parts || (parts = [])).push(String.fromCharCode.apply(String, chunk));
            i = 0;
        }
    }
    if (j) {
        chunk[i++] = b64[t];
        chunk[i++] = 61;
        if (j === 1)
            chunk[i++] = 61;
    }
    if (parts) {
        if (i)
            parts.push(String.fromCharCode.apply(String, chunk.slice(0, i)));
        return parts.join("");
    }
    return String.fromCharCode.apply(String, chunk.slice(0, i));


}