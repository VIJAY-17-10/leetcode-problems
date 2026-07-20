var checkIfInstanceOf = function(obj, classFunction) {
    if (classFunction == null) return false;

    while (obj != null) {
        if (Object.getPrototypeOf(obj) === classFunction.prototype) {
            return true;
        }
        obj = Object.getPrototypeOf(obj);
    }

    return false;
};
